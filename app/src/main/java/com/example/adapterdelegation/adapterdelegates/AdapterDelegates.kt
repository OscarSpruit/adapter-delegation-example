package com.example.adapterdelegation.adapterdelegates

import com.bumptech.glide.Glide
import com.example.adapterdelegation.SpaceItemDecoration
import com.example.adapterdelegation.data.Item
import com.example.adapterdelegation.databinding.ItemBasicBinding
import com.example.adapterdelegation.databinding.ItemNestedCardBinding
import com.example.adapterdelegation.databinding.ItemNestedWithHeaderBinding
import com.example.adapterdelegation.databinding.ItemToggleBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun basicAdapterDelegate() = adapterDelegateViewBinding<Item.Basic, Item, ItemBasicBinding>(
    { layoutInflater, parent -> ItemBasicBinding.inflate(layoutInflater, parent, false) }
) {
    bind {
        binding.title.text = item.title
        Glide.with(binding.root)
            .load(item.image)
            .into(binding.image)
    }
}

fun nestedAdapterDelegate() = adapterDelegateViewBinding<Item.Nested, Item, ItemNestedWithHeaderBinding>(
    { layoutInflater, parent -> ItemNestedWithHeaderBinding.inflate(layoutInflater, parent, false) }
) {
    val decoration = SpaceItemDecoration(context, SpaceItemDecoration.HORIZONTAL)
    binding.list.addItemDecoration(decoration)

    bind {
        binding.title.text = item.title
        binding.list.adapter = ListDelegationAdapter(nestedCardAdapterDelegate()).apply {
            items = item.items
        }
    }
}

private fun nestedCardAdapterDelegate() = adapterDelegateViewBinding<String, String, ItemNestedCardBinding>(
    { layoutInflater, parent -> ItemNestedCardBinding.inflate(layoutInflater, parent, false) }
) {
    bind {
        binding.text.text = item
    }
}

fun toggleAdapterDelegate() = adapterDelegateViewBinding<Item.Toggle, Item, ItemToggleBinding>(
    { layoutInflater, parent -> ItemToggleBinding.inflate(layoutInflater, parent, false) }
) {
    bind {
        binding.toggle.text = item.title
        binding.toggle.isChecked = item.enabled
    }
}
