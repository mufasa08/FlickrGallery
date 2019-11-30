package com.mdualeh.galleryScreen.datasource.model

import com.mdualeh.galleryScreen.domain.model.GalleryItem
import com.squareup.moshi.Json

data class Media(@field:Json(name = "m") val imageUrl: String)

data class GalleryItemEntity(
    @field:Json(name = "title") val title: String,
    @field:Json(name = "link") val link: String,
    @field:Json(name = "media") val media: Media,
    @field:Json(name = "date_taken") val dateTaken: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "published") val published: String,
    @field:Json(name = "author") val author: String,
    @field:Json(name = "author_id") val authorId: String,
    @field:Json(name = "tags") val tags: String
)

// todo verify assumption tags split by space and /
fun GalleryItemEntity.mapToDomain(): GalleryItem =
    GalleryItem(title, media.imageUrl, link, author, description, tags.split(" ", "/"), dateTaken, published)

fun List<GalleryItemEntity>.mapToDomain(): List<GalleryItem> = map { it.mapToDomain() }
