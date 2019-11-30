package com.mdualeh.galleryScreen

import com.mdualeh.galleryScreen.datasource.model.GalleryItemEntity
import com.mdualeh.galleryScreen.datasource.model.Media
import com.mdualeh.galleryScreen.domain.model.GalleryItem

val galleryItem = GalleryItem(
    "fakeimage.jpg",
    "https://dummyurl.com/fakeimage.jpg",
    "https://www.fakeurl.com/photos/1000000/",
    "Mustafa Dualeh",
    "This is some random image i uploaded because I thought it was cool.",
    listOf("cute", "funny"),
    "2019-11-30T00:00:00Z",
    "2019-11-31T12:00:00Z"
)

val galleryItemEntity = GalleryItemEntity(
    "fakeimage.jpg",
    "https://www.fakeurl.com/photos/1000000/",
    Media("https://dummyurl.com/fakeimage.jpg"),
    "2019-11-30T00:00:00Z",
    "This is some random image i uploaded because I thought it was cool.",
    "2019-11-31T12:00:00Z",
    "Mustafa Dualeh",
    "109198176",
    "cute funny"
)
