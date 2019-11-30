package com.mdualeh.galleryScreen.domain.model

data class GalleryItem(
    val itemName: String,
    val itemImageUrl: String,
    val itemUrl: String,
    val author: String,
    val description: String,
    val tags: List<String>,
    val dateTaken: String,
    val datePublished: String
)