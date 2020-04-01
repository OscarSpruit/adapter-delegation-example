package com.example.adapterdelegation.data

object ItemDataSource {

    fun getItems(): List<Item> = listOf(
        Item.Basic("Lorem ipsum dolor sit amet", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Nested("Mauris quis", getNestedItems()),
        Item.Basic("Integer nunc felis", "https://picsum.photos/200"),
        Item.Toggle("Proin elementum", false),
        Item.Basic("Ut sit amet massa quis massa tincidunt rutrum", "https://picsum.photos/200"),
        Item.Basic("Morbi vitae magna in", "https://picsum.photos/200"),
        Item.Nested("Duis vel orci a lacus", getNestedItems()),
        Item.Nested("Donec cursus viverra", getNestedItems()),
        Item.Toggle("Etiam in mi ultrices", true),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Basic("Mauris tortor nisi", "https://picsum.photos/200"),
        Item.Nested("Donec cursus viverra", getNestedItems())
    )

    private fun getNestedItems() = listOf(
        "foo",
        "bar",
        "baz",
        "qux",
        "quux",
        "quuz",
        "corge",
        "grault",
        "garply",
        "waldo",
        "fred",
        "plugh",
        "xyzzy",
        "thud"
    )
}

sealed class Item {

    data class Basic(
        val title: String,
        val image: String
    ) : Item()

    data class Nested(
        val title: String,
        val items: List<String>
    ) : Item()

    data class Toggle(
        val title: String,
        val enabled: Boolean
    ) : Item()
}
