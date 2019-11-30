package com.mdualeh.navigation.features

import android.content.Intent
import com.mdualeh.navigation.loadIntentOrNull

object AppMainNavigation : DynamicFeature<Intent> {

    private const val DYNAMICSCREEN =
        "com.mdualeh.galleryScreen.ui.views.GalleryScreenActivity"

    override val dynamicStart: Intent?
        get() = DYNAMICSCREEN.loadIntentOrNull()
}
