package com.mdualeh.galleryScreen.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.mdualeh.galleryScreen.R
import com.mdualeh.galleryScreen.injectFeature
import com.mdualeh.galleryScreen.ui.model.GalleryListItem
import com.mdualeh.galleryScreen.ui.viewmodel.GalleryViewModel
import com.mdualeh.navigation.features.AppMainNavigation
import com.mdualeh.presentation.Resource
import com.mdualeh.presentation.ResourceState
import com.mdualeh.presentation.startRefreshing
import com.mdualeh.presentation.stopRefreshing
import kotlinx.android.synthetic.main.activity_gallery.*
import org.koin.androidx.viewmodel.ext.viewModel

class GalleryScreenActivity : AppCompatActivity() {

    private val vm: GalleryViewModel by viewModel()
    private val adapter by lazy { GalleryItemListAdapter(itemClick) }
    private val snackBar by lazy {
        Snackbar.make(swipeRefreshLayout, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.retry)) { vm.get(refresh = true) }
    }
    private val itemClick: (GalleryListItem) -> Unit =
        { startActivity(AppMainNavigation.galleryDetails(it.author, it.itemName, it.datePublished)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        injectFeature()
        if (savedInstanceState == null) {
            vm.get(true)
        }
        vm.galleryItems.observe(this, Observer { updateGalleryItems(it) })
        galleriesRecyclerView.adapter = adapter
        swipeRefreshLayout.setOnRefreshListener { vm.get(refresh = true) }
    }
    private fun updateGalleryItems(resource: Resource<List<GalleryListItem>>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> swipeRefreshLayout.startRefreshing()
                ResourceState.SUCCESS -> swipeRefreshLayout.stopRefreshing()
                ResourceState.ERROR -> swipeRefreshLayout.stopRefreshing()
            }
            it.data?.let { adapter.submitList(it) }
            it.message?.let { snackBar.show() }
        }
    }
}