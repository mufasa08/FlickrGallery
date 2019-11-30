package com.mdualeh.galleryScreen.ui.views

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mdualeh.galleryScreen.R
import com.mdualeh.galleryScreen.ui.model.GalleryListItem
import com.mdualeh.presentation.inflate
import com.mdualeh.presentation.loadImage
import kotlinx.android.synthetic.main.gallery_list_sale_item.view.*

class GalleryItemListAdapter(private val itemClick: (GalleryListItem) -> Unit) :
    ListAdapter<GalleryListItem, GalleryItemListAdapter.ViewHolder>(GalleryItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.gallery_list_sale_item)) {

        fun bind(item: GalleryListItem) {
            itemView.itemImage.loadImage(item.itemImageUrl)
            itemView.setOnClickListener { itemClick.invoke(item) }
        }
    }
}

private class GalleryItemDiffCallback : DiffUtil.ItemCallback<GalleryListItem>() {
    override fun areItemsTheSame(oldItem: GalleryListItem, newItem: GalleryListItem): Boolean =
        oldItem.itemName == newItem.itemName

    override fun areContentsTheSame(oldItem: GalleryListItem, newItem: GalleryListItem): Boolean =
        oldItem == newItem
}
