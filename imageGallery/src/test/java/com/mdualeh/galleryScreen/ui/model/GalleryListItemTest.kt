@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.ui.model

import com.mdualeh.galleryScreen.galleryItem
import org.junit.Assert.assertTrue
import org.junit.Test

class GalleryListItemTest {

    @Test
    fun `map domain to ui model`() {

        // when
        val galleryListItem = listOf(galleryItem).mapToUIModel().first()

        assertTrue(galleryListItem.itemName == galleryItem.itemName)
        assertTrue(galleryListItem.itemImageUrl == galleryItem.itemImageUrl)
        assertTrue(galleryListItem.itemUrl == galleryItem.itemUrl)
        assertTrue(galleryListItem.author == galleryItem.author)
        assertTrue(galleryListItem.description == galleryItem.description)
        assertTrue(galleryListItem.tags == galleryItem.tags)
        assertTrue(galleryListItem.dateTaken == galleryItem.dateTaken)
        assertTrue(galleryListItem.datePublished == galleryItem.datePublished)
    }
}
