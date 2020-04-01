package com.example.adapterdelegation.groupie

import com.example.adapterdelegation.data.Item
import com.xwray.groupie.Group
import com.xwray.groupie.Section

object ViewHolderMapper {

    fun map(items: List<Item>): List<Group> = items.map {
        when(it) {
            is Item.Basic -> mapBasic(it)
            is Item.Nested -> mapNested(it)
            is Item.Toggle -> mapToggle(it)
        }
    }

    private fun mapBasic(item: Item.Basic) = BasicItem(item)

    private fun mapNested(item: Item.Nested) = Section().apply {
        setHeader(NestedHeaderItem(item))
        add(NestedItem(item))
    }

    private fun mapToggle(item: Item.Toggle) = ToggleItem(item)
}
