package com.example.adapterdelegation.groupie

import com.example.adapterdelegation.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_nested_card.view.*

class NestedCardItem(private val text: String) : Item() {

    override fun getLayout(): Int = R.layout.item_nested_card

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.containerView.text.text = text
    }
}
