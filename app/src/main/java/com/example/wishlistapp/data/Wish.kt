package com.example.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title="Google Watch 2", description = "Android watch"),
        Wish(title="New book", description = "Sci-fi"),
        Wish(title="Mega car", description = "vroom vroom")
    )
}