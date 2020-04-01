package com.example.adapterdelegation.groupie

import com.example.adapterdelegation.R
import com.example.adapterdelegation.data.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_toggle.view.*
import com.xwray.groupie.kotlinandroidextensions.Item as GroupieItem

class ToggleItem(private val item: Item.Toggle) : GroupieItem() {

    override fun getLayout(): Int = R.layout.item_toggle

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.containerView.toggle.text = item.title
        viewHolder.containerView.toggle.isChecked = item.enabled
    }
}
