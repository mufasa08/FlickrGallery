package com.mdualeh.galleryScreen

import com.mdualeh.galleryScreen.data.repository.GalleryItemRepositoryImpl
import com.mdualeh.galleryScreen.domain.repository.GalleryItemRepository
import com.mdualeh.homescreen.domain.usecase.GalleryItemUseCase
import com.mdualeh.homescreen.presentation.homescreen.GalleryItemsViewModel
import com.mdualeh.network.createNetworkClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        useCaseModule,
        viewModelModule,
        repositoryModule
    )
}

private const val BASE_URL = ""

private val retrofit: Retrofit = createNetworkClient(BASE_URL, BuildConfig.DEBUG)

val useCaseModule: Module = module {
    factory { GalleryItemUseCase(galleryItemRepository = get()) }
}

val viewModelModule: Module = module {
    viewModel { GalleryItemsViewModel(galleryItemUseCase = get()) }
}

val repositoryModule: Module = module {
    single {
        GalleryItemRepositoryImpl(
            cacheDataSource = get(),
            remoteDataSource = get()
        ) as GalleryItemRepository
    }
}