package com.mdualeh.homescreen.datasource.model

import com.mdualeh.galleryScreen.datasource.model.Media
import com.squareup.moshi.Json

class RSSFeedItem {

    @Json(name = "title")
    var title: String? = null
    @Json(name = "link")
    var link: String? = null
    @Json(name = "media")
    var media: Media? = null
    @Json(name = "date_taken")
    var dateTaken: String? = null
    @Json(name = "description")
    var description: String? = null
    @Json(name = "published")
    var published: String? = null
    @Json(name = "author")
    var author: String? = null
    @Json(name = "author_id")
    var authorId: String? = null
    @Json(name = "tags")
    var tags: String? = null
}