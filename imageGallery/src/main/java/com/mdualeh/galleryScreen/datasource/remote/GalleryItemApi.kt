package com.mdualeh.galleryScreen.datasource.remote

import com.mdualeh.galleryScreen.datasource.model.ResponseItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryItemApi {

    @GET("/services/feeds/photos_public.gne?nojsoncallback=?")
    fun getGalleryItems(@Query("format") format: String): Single<ResponseItem>
}
