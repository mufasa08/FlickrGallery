@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.domain.usecase

import com.mdualeh.galleryScreen.domain.repository.GalleryItemRepository
import com.mdualeh.galleryScreen.galleryItem
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GalleryItemUseCaseTest {

    private lateinit var usecase: GalleryItemUseCase

    private val mockRepository: GalleryItemRepository = mock()

    private val galleryItemList = listOf(galleryItem)

    @Before
    fun setUp() {
        usecase = GalleryItemUseCase(mockRepository)
    }

    @Test
    fun `repository get success`() {
        // given
        whenever(mockRepository.get(false)).thenReturn(Single.just(galleryItemList))

        // when
        val test = usecase.get(false).test()

        // then
        verify(mockRepository).get(false)

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(galleryItemList)
    }

    @Test
    fun `repository get fail`() {
        // given
        val throwable = Throwable()
        whenever(mockRepository.get(false)).thenReturn(Single.error(throwable))

        // when
        val test = usecase.get(false).test()

        // then
        verify(mockRepository).get(false)

        test.assertNoValues()
        test.assertNotComplete()
        test.assertError(throwable)
        test.assertValueCount(0)
    }
}
