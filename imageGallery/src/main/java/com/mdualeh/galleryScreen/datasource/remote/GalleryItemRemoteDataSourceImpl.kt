package com.mdualeh.galleryScreen.datasource.remote

import com.mdualeh.galleryScreen.data.datasource.GalleryItemRemoteDataSource
import com.mdualeh.galleryScreen.datasource.model.mapToDomain
import com.mdualeh.galleryScreen.domain.model.GalleryItem
import io.reactivex.Single

class GalleryItemRemoteDataSourceImpl constructor(
    private val api: GalleryItemApi
) : GalleryItemRemoteDataSource {

    override fun get(): Single<List<GalleryItem>> =
        api.getGalleryItems("json")
            .map { it.mapToDomain() }
}
