package com.mdualeh.galleryScreen

import com.mdualeh.homescreen.domain.usecase.GalleryItemUseCase
import com.mdualeh.network.createNetworkClient
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        useCaseModule
    )
}

private const val BASE_URL = ""

private val retrofit: Retrofit = createNetworkClient(BASE_URL, BuildConfig.DEBUG)

val useCaseModule: Module = module {
    factory { GalleryItemUseCase(galleryItemRepository = get()) }
}