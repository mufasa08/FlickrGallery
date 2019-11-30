package com.mdualeh.galleryScreen.data.repository

import com.mdualeh.galleryScreen.data.datasource.GalleryItemCacheDataSource
import com.mdualeh.galleryScreen.data.datasource.GalleryItemRemoteDataSource
import com.mdualeh.galleryScreen.domain.model.GalleryItem
import com.mdualeh.galleryScreen.domain.repository.GalleryItemRepository
import io.reactivex.Single

class GalleryItemRepositoryImpl constructor(
    private val cacheDataSource: GalleryItemCacheDataSource,
    private val remoteDataSource: GalleryItemRemoteDataSource
) : GalleryItemRepository {

    override fun get(refresh: Boolean): Single<List<GalleryItem>> =
        when (refresh) {
            true -> remoteDataSource.get()
                .flatMap { cacheDataSource.set(it) }
            false -> cacheDataSource.get()
                .onErrorResumeNext { get(true) }
        }
}
