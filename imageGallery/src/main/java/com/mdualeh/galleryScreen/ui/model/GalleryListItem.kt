package com.mdualeh.galleryScreen.ui.model

import com.mdualeh.galleryScreen.domain.model.GalleryItem

data class GalleryListItem(
    val itemName: String,
    val itemImageUrl: String,
    val itemUrl: String,
    val author: String,
    val description: String,
    val tags: List<String>,
    val dateTaken: String,
    val datePublished: String
)

fun List<GalleryItem>.mapToUIModel(): List<GalleryListItem> =
    map { GalleryListItem(it.itemName, it.itemImageUrl, it.itemUrl, it.author, it.description, it.tags, it.dateTaken, it.datePublished) }
