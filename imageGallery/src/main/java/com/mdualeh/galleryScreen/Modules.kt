package com.mdualeh.galleryScreen

import com.mdualeh.cache.ReactiveCache
import com.mdualeh.galleryScreen.data.datasource.GalleryItemCacheDataSource
import com.mdualeh.galleryScreen.data.datasource.GalleryItemRemoteDataSource
import com.mdualeh.galleryScreen.data.repository.GalleryItemRepositoryImpl
import com.mdualeh.galleryScreen.datasource.cache.GalleryItemCacheDataSourceImpl
import com.mdualeh.galleryScreen.datasource.model.GalleryItemEntity
import com.mdualeh.galleryScreen.datasource.remote.GalleryItemApi
import com.mdualeh.galleryScreen.datasource.remote.GalleryItemRemoteDataSourceImpl
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
        repositoryModule,
        dataSourceModule,
        networkModule,
        cacheModule
    )
}

private const val BASE_URL = "https://www.flickr.com/"

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

val dataSourceModule: Module = module {
    single { GalleryItemRemoteDataSourceImpl(api = galleryItemApi) as GalleryItemRemoteDataSource }
    single { GalleryItemCacheDataSourceImpl(cache = get(GALLERYITEM_CACHE)) as GalleryItemCacheDataSource }
}

val networkModule: Module = module {
    single { galleryItemApi }
}

val cacheModule: Module = module {
    single(name = GALLERYITEM_CACHE) { ReactiveCache<List<GalleryItemEntity>>() }
}

private val galleryItemApi: GalleryItemApi = retrofit.create(GalleryItemApi::class.java)
private const val GALLERYITEM_CACHE = "GALLERYITEM_CACHE"