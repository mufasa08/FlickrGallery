package com.mdualeh.galleryScreen.domain.usecase

import com.mdualeh.galleryScreen.domain.model.GalleryItem
import com.mdualeh.galleryScreen.domain.repository.GalleryItemRepository
import io.reactivex.Single

class GalleryItemUseCase constructor(private val galleryItemRepository: GalleryItemRepository) {

    fun get(refresh: Boolean): Single<List<GalleryItem>> =
        galleryItemRepository.get(refresh)
}