@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.data.repository

import com.mdualeh.galleryScreen.data.datasource.GalleryItemCacheDataSource
import com.mdualeh.galleryScreen.data.datasource.GalleryItemRemoteDataSource
import com.mdualeh.galleryScreen.galleryItem
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GalleryItemRepositoryImplTest {

    private lateinit var repository: GalleryItemRepositoryImpl

    private val mockCacheDataSource: GalleryItemCacheDataSource = mock()
    private val mockRemoteDataSource: GalleryItemRemoteDataSource = mock()

    private val cacheItem = galleryItem.copy()
    private val remoteItem = galleryItem.copy()

    private val cacheList = listOf(cacheItem)
    private val remoteList = listOf(remoteItem)

    private val throwable = Throwable()

    @Before
    fun setUp() {
        repository = GalleryItemRepositoryImpl(mockCacheDataSource, mockRemoteDataSource)
    }

    @Test
    fun `get galleryItems cache success`() {
        // given
        whenever(mockCacheDataSource.get()).thenReturn(Single.just(cacheList))

        // when
        val test = repository.get(false).test()

        // then
        verify(mockCacheDataSource).get()
        test.assertValue(cacheList)
    }

    @Test
    fun `get galleryItems cache fail fallback remote succeeds`() {
        // given
        whenever(mockCacheDataSource.get()).thenReturn(Single.error(throwable))
        whenever(mockRemoteDataSource.get()).thenReturn(Single.just(remoteList))
        whenever(mockCacheDataSource.set(remoteList)).thenReturn(
            Single.just(
                remoteList
            )
        )

        // when
        val test = repository.get(false).test()

        // then
        verify(mockCacheDataSource).get()
        verify(mockRemoteDataSource).get()
        verify(mockCacheDataSource).set(remoteList)
        test.assertValue(remoteList)
    }

    @Test
    fun `get galleryItems remote success`() {
        // given
        whenever(mockRemoteDataSource.get()).thenReturn(Single.just(remoteList))
        whenever(mockCacheDataSource.set(remoteList)).thenReturn(
            Single.just(
                remoteList
            )
        )

        // when
        val test = repository.get(true).test()

        // then
        verify(mockRemoteDataSource).get()
        verify(mockCacheDataSource).set(remoteList)
        test.assertValue(remoteList)
    }

    @Test
    fun `get galleryItems remote fail`() {
        // given
        whenever(mockRemoteDataSource.get()).thenReturn(Single.error(throwable))

        // when
        val test = repository.get(true).test()

        // then
        verify(mockRemoteDataSource).get()
        test.assertError(throwable)
    }
}
