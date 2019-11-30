package com.mdualeh.galleryScreen.data.datasource

import com.mdualeh.galleryScreen.domain.model.GalleryItem
import io.reactivex.Single

interface GalleryItemCacheDataSource {

    fun get(): Single<List<GalleryItem>>

    fun set(list: List<GalleryItem>): Single<List<GalleryItem>>
}

interface GalleryItemRemoteDataSource {

    fun get(): Single<List<GalleryItem>>
}
