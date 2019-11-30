package com.mdualeh.galleryScreen.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdualeh.galleryScreen.domain.usecase.GalleryItemUseCase
import com.mdualeh.galleryScreen.ui.model.GalleryListItem
import com.mdualeh.galleryScreen.ui.model.mapToUIModel
import com.mdualeh.presentation.Resource
import com.mdualeh.presentation.setError
import com.mdualeh.presentation.setLoading
import com.mdualeh.presentation.setSuccess
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GalleryViewModel constructor(private val galleryItemUseCase: GalleryItemUseCase) :
    ViewModel() {
    val galleryItems = MutableLiveData<Resource<List<GalleryListItem>>>()
    private val compositeDisposable = CompositeDisposable()

    fun get(refresh: Boolean) =
        compositeDisposable.add(galleryItemUseCase.get(refresh)
            .doOnSubscribe { galleryItems.setLoading() }
            .subscribeOn(Schedulers.io())
            .map { it.mapToUIModel() }
            .subscribe({ galleryItems.setSuccess(it) }, { galleryItems.setError(it.message) })
        )

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
