package com.example.adapterdelegation.cycler

import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout.LayoutParams
import com.bumptech.glide.Glide
import com.example.adapterdelegation.SpaceItemDecoration
import com.example.adapterdelegation.data.Item
import com.example.adapterdelegation.databinding.ItemBasicBinding
import com.example.adapterdelegation.databinding.ItemNestedCardBinding
import com.example.adapterdelegation.databinding.ItemNestedWithHeaderBinding
import com.example.adapterdelegation.databinding.ItemToggleBinding
import com.squareup.cycler.Recycler
import com.squareup.cycler.toDataSource

fun Recycler.Config<Item>.basicRow() {
    row<Item.Basic, View> {
        create { context ->
            val binding = ItemBasicBinding.inflate(LayoutInflater.from(context))
            view = binding.root

            bind { subItem: Item.Basic ->
                binding.title.text = subItem.title
                Glide.with(binding.root)
                    .load(subItem.image)
                    .into(binding.image)
            }
        }
    }
}

fun Recycler.Config<Item>.nestedRow() {
    row<Item.Nested, View> {
        create { context ->
            val binding = ItemNestedWithHeaderBinding.inflate(LayoutInflater.from(context))
            view = binding.root

            val decoration = SpaceItemDecoration(context, SpaceItemDecoration.HORIZONTAL)
            binding.list.addItemDecoration(decoration)

            val recycler = Recycler.adopt<String>(binding.list) {
                nestedCardRow()
            }

            bind { subItem: Item.Nested ->
                binding.title.text = subItem.title
                recycler.data = subItem.items.toDataSource()
            }
        }
    }
}

private fun Recycler.Config<String>.nestedCardRow() {
    this.row<String, View> {
        create { context ->
            val binding = ItemNestedCardBinding.inflate(LayoutInflater.from(context))
            view = binding.root

            // Hack to maintain WRAP_CONTENT. Atm Cycler sets the width to MATCH_PARENT by themselves.
            view.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

            bind { subItem ->
                binding.text.text = subItem
            }
        }
    }
}

fun Recycler.Config<Item>.toggleRow() {
    row<Item.Toggle, View> {
        create { context ->
            val binding = ItemToggleBinding.inflate(LayoutInflater.from(context))
            view = binding.root

            bind { subItem: Item.Toggle ->
                binding.toggle.text = subItem.title
                binding.toggle.isChecked = subItem.enabled
            }
        }
    }
}
