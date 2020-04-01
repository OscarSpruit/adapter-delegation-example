package com.example.adapterdelegation.groupie

import android.view.View
import com.example.adapterdelegation.R
import com.example.adapterdelegation.SpaceItemDecoration
import com.example.adapterdelegation.data.Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.item_nested.view.*
import com.xwray.groupie.kotlinandroidextensions.Item as GroupieItem

class NestedItem(private val item: Item.Nested) : GroupieItem() {

    override fun getLayout(): Int = R.layout.item_nested

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        val decoration = SpaceItemDecoration(itemView.context, SpaceItemDecoration.HORIZONTAL)
        itemView.list.addItemDecoration(decoration)
        return super.createViewHolder(itemView)
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.containerView.list.adapter = GroupAdapter<GroupieViewHolder>().apply {
            item.items.forEach {
                add(NestedCardItem(it))
            }
        }
    }
}
