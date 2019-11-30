@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.datasource.cache

import com.mdualeh.cache.ReactiveCache
import com.mdualeh.galleryScreen.domain.model.GalleryItem
import com.mdualeh.galleryScreen.galleryItem
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GalleryItemCacheDataSourceImplTest {

    private lateinit var dataSource: GalleryItemCacheDataSourceImpl

    private val mockCache: ReactiveCache<List<GalleryItem>> = mock()

    val key = "GalleryItem List"

    private val cacheItem = galleryItem.copy()
    private val remoteItem = galleryItem.copy()

    private val cacheList = listOf(cacheItem)
    private val remoteList = listOf(remoteItem)

    private val throwable = Throwable()

    @Before
    fun setUp() {
        dataSource = GalleryItemCacheDataSourceImpl(mockCache)
    }

    @Test
    fun `get galleryItem cache success`() {
        // given
        whenever(mockCache.load(key)).thenReturn(Single.just(cacheList))

        // when
        val test = dataSource.get().test()

        // then
        verify(mockCache).load(key)
        test.assertValue(cacheList)
    }

    @Test
    fun `get galleryItem cache fail`() {
        // given
        whenever(mockCache.load(key)).thenReturn(Single.error(throwable))

        // when
        val test = dataSource.get().test()

        // then
        verify(mockCache).load(key)
        test.assertError(throwable)
    }

    @Test
    fun `set galleryItem cache success`() {
        // given
        whenever(mockCache.save(key, remoteList)).thenReturn(Single.just(remoteList))

        // when
        val test = dataSource.set(remoteList).test()

        // then
        verify(mockCache).save(key, remoteList)
        test.assertValue(remoteList)
    }

    @Test
    fun `set galleryItem cache fail`() {
        // given
        whenever(mockCache.save(key, remoteList)).thenReturn(Single.error(throwable))

        // when
        val test = dataSource.set(remoteList).test()

        // then
        verify(mockCache).save(key, remoteList)
        test.assertError(throwable)
    }
}
