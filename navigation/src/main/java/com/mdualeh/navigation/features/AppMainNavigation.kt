package com.mdualeh.navigation.features

import android.content.Intent
import com.mdualeh.navigation.loadIntentOrNull

object AppMainNavigation : DynamicFeature<Intent> {

    //TODO specify path of first screen
    private const val DYNAMICSCREEN =
        "com.*.*"

    //example get() = DYNAMICSCREEN.loadIntentOrNull()
    override val dynamicStart: Intent?
        get() = TODO()

}
