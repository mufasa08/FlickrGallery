package com.mdualeh.galleryScreen.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mdualeh.galleryScreen.R
import com.mdualeh.galleryScreen.injectFeature
import com.mdualeh.galleryScreen.ui.model.GalleryListItem
import com.mdualeh.galleryScreen.ui.viewmodel.GalleryViewModel
import com.mdualeh.navigation.features.AppMainNavigation
import com.mdualeh.presentation.Resource
import com.mdualeh.presentation.loadImage
import kotlinx.android.synthetic.main.gallery_list_sale_item.*
import org.koin.androidx.viewmodel.ext.viewModel

class GalleryItemDetailsActivity : AppCompatActivity() {

    private val vm: GalleryViewModel by viewModel()
    private val author by lazy { intent.getStringExtra(AppMainNavigation.AUTHOR_KEY) }
    private val title by lazy { intent.getStringExtra(AppMainNavigation.TITLE_KEY) }
    private val datePublished by lazy { intent.getStringExtra(AppMainNavigation.DATE_PUBLISHED_KEY) }
    private var currentItem: GalleryListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_details)
        injectFeature()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            // use cache instead of fresh
            vm.get(false)
        }

        vm.galleryItems.observe(this, Observer { updateGalleryItems(it) })
    }
    private fun updateGalleryItems(resource: Resource<List<GalleryListItem>>?) {
        resource?.let {
                // this is naive solution. Idealy cache should have an id that you can use to fetch
            currentItem = it.data?.first { it.itemName == title && it.author == author && it.datePublished == datePublished }
            currentItem?.itemImageUrl?.let { it1 -> itemImage.loadImage(it1) }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
