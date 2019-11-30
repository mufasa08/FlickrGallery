package com.mdualeh.galleryScreen

import com.mdualeh.network.createNetworkClient
import org.koin.core.context.loadKoinModules
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules()
}

private const val BASE_URL = ""

private val retrofit: Retrofit = createNetworkClient(BASE_URL, BuildConfig.DEBUG)
