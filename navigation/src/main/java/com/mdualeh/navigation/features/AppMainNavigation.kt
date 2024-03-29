package com.mdualeh.navigation.features

import android.content.Intent
import android.net.Uri
import com.mdualeh.navigation.loadIntentOrNull

object AppMainNavigation : DynamicFeature<Intent> {

    const val AUTHOR_KEY = "AUTHOR_KEY"
    const val TITLE_KEY = "TITLE_KEY"
    const val DATE_PUBLISHED_KEY = "DATE_PUBLISHED_KEY"

    private const val GALLERY_SCREEN =
        "com.mdualeh.galleryScreen.ui.views.GalleryScreenActivity"
    private const val GALLERY_DETAILS = "com.mdualeh.galleryScreen.ui.views.GalleryItemDetailsActivity"

    override val dynamicStart: Intent?
        get() = GALLERY_SCREEN.loadIntentOrNull()

    fun galleryDetails(author: String, title: String, datePublished: String): Intent? =
        GALLERY_DETAILS.loadIntentOrNull()
            ?.apply {
                putExtra(AUTHOR_KEY, author)
                putExtra(TITLE_KEY, title)
                putExtra(DATE_PUBLISHED_KEY, datePublished)
            }

    fun browserIntent(url: String): Intent? = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    fun emailIntent(url: String, subject: String): Intent {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.setType("text/plain")
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, url)
        return(Intent.createChooser(emailIntent, "Email:"))
    }
}
