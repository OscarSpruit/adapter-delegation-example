package com.example.adapterdelegation.groupie

import com.bumptech.glide.Glide
import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_basic.view.*
import com.xwray.groupie.kotlinandroidextensions.Item as GroupieItem

class BasicItem(private val item: Item.Basic) : GroupieItem() {

    override fun getLayout(): Int = R.layout.item_basic

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.containerView.title.text = item.title

        Glide.with(viewHolder.containerView)
            .load(item.image)
            .into(viewHolder.containerView.image)
    }
}
