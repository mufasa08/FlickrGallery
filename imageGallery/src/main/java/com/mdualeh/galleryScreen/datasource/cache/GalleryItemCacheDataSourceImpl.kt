package com.mdualeh.galleryScreen.datasource.cache

import com.mdualeh.cache.ReactiveCache
import com.mdualeh.galleryScreen.data.datasource.GalleryItemCacheDataSource
import com.mdualeh.galleryScreen.domain.model.GalleryItem
import io.reactivex.Single

class GalleryItemCacheDataSourceImpl constructor(
    private val cache: ReactiveCache<List<GalleryItem>>
) : GalleryItemCacheDataSource {

    val key = "GalleryItem List"

    override fun get(): Single<List<GalleryItem>> =
        cache.load(key)

    override fun set(list: List<GalleryItem>): Single<List<GalleryItem>> =
        cache.save(key, list)
}
