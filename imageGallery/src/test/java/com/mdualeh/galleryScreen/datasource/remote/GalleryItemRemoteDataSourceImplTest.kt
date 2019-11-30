@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.datasource.remote

import com.mdualeh.galleryScreen.datasource.model.mapToDomain
import com.mdualeh.galleryScreen.galleryItemEntity
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GalleryItemRemoteDataSourceImplTest {

    private lateinit var dataSource: GalleryItemRemoteDataSourceImpl

    private val mockApi: GalleryItemApi = mock()

    private val remoteItem = galleryItemEntity.copy()

    private val remoteList = listOf(remoteItem)

    private val throwable = Throwable()

    private val formatQueryParam = "json"

    @Before
    fun setUp() {
        dataSource = GalleryItemRemoteDataSourceImpl(mockApi)
    }

    @Test
    fun `get comments remote success`() {
        // given
        whenever(mockApi.getGalleryItems(formatQueryParam)).thenReturn(Single.just(remoteList))

        // when
        val test = dataSource.get().test()

        // then
        verify(mockApi).getGalleryItems(formatQueryParam)
        test.assertValue(remoteList.mapToDomain())
    }

    @Test
    fun `get comments remote fail`() {
        // given
        whenever(mockApi.getGalleryItems(formatQueryParam)).thenReturn(Single.error(throwable))

        // when
        val test = dataSource.get().test()

        // then
        verify(mockApi).getGalleryItems(formatQueryParam)
        test.assertError(throwable)
    }
}
