package com.mdualeh.galleryScreen.ui.galleryScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mdualeh.galleryScreen.R
import com.mdualeh.galleryScreen.injectFeature

class GalleryScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        injectFeature()
    }
}