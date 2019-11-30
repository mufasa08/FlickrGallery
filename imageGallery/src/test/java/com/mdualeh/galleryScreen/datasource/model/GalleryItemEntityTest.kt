@file:Suppress("IllegalIdentifier")

package com.mdualeh.galleryScreen.datasource.model

import com.mdualeh.galleryScreen.galleryItem
import com.mdualeh.galleryScreen.galleryItemEntity
import org.junit.Assert.assertTrue
import org.junit.Test

class GalleryItemEntityTest {

    @Test
    fun `map entity to domain`() {
        // given

        // when
        val model = galleryItemEntity.mapToDomain()

        // then
        assertTrue(model.itemName == galleryItem.itemName)
        assertTrue(model.itemImageUrl == galleryItem.itemImageUrl)
        assertTrue(model.itemUrl == galleryItem.itemUrl)
        assertTrue(model.author == galleryItem.author)
        assertTrue(model.description == galleryItem.description)
        assertTrue(model.tags == galleryItem.tags)
        assertTrue(model.dateTaken == galleryItem.dateTaken)
        assertTrue(model.datePublished == galleryItem.datePublished)
    }
}
