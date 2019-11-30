@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.ui.gallery

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mdualeh.galleryScreen.galleryItem
import com.mdualeh.galleryScreen.ui.RxSchedulersOverrideRule
import com.mdualeh.galleryScreen.ui.model.mapToUIModel
import com.mdualeh.homescreen.domain.usecase.GalleryItemUseCase
import com.mdualeh.homescreen.presentation.homescreen.GalleryItemsViewModel
import com.mdualeh.presentation.Resource
import com.mdualeh.presentation.ResourceState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GalleryItemListViewModelTest {

    private lateinit var viewModel: GalleryItemsViewModel

    private val mockUseCase: GalleryItemUseCase = mock()

    private val galleryItemsListItem = listOf(galleryItem)

    private val throwable = Throwable()

    @Rule
    @JvmField
    val rxSchedulersOverrideRule = RxSchedulersOverrideRule()

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = GalleryItemsViewModel(mockUseCase)
    }

    @Test
    fun `get galleryItems item list succeeds`() {
        // given
        whenever(mockUseCase.get(false)).thenReturn(Single.just(galleryItemsListItem))

        // when
        viewModel.get(false)

        // then
        verify(mockUseCase).get(false)
        assertEquals(
            Resource(ResourceState.SUCCESS, galleryItemsListItem.mapToUIModel(), null),
            viewModel.galleryItems.value
        )
    }

    @Test
    fun `get galleryItems item list fails`() {
        // given
        whenever(mockUseCase.get(false)).thenReturn(Single.error(throwable))

        // when
        viewModel.get(false)

        // then
        verify(mockUseCase).get(false)
        assertEquals(
            Resource(ResourceState.ERROR, null, throwable.message),
            viewModel.galleryItems.value
        )
    }
}
