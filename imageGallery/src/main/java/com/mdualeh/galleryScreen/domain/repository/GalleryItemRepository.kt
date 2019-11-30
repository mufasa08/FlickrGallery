package com.mdualeh.galleryScreen.domain.repository

import com.mdualeh.galleryScreen.domain.model.GalleryItem
import io.reactivex.Single

interface GalleryItemRepository {

    fun get(refresh: Boolean): Single<List<GalleryItem>>
}