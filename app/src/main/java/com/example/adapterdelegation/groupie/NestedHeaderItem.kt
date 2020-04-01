package com.example.adapterdelegation.groupie

import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_nested_header.view.*
import com.xwray.groupie.kotlinandroidextensions.Item as GroupieItem

class NestedHeaderItem(private val item: Item.Nested) : GroupieItem() {

    override fun getLayout(): Int = R.layout.item_nested_header

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.containerView.title.text = item.title
    }
}
