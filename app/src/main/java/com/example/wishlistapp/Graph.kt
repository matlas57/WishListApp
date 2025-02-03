package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

//object indicates a singleton: where only one instance will ever exist
//This object maintains and provides dependencies throughout our app when different components require database access
object Graph {
    lateinit var database: WishDatabase

    //by lazy initializes the variable at the moment its first needed
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    //builds the database when this function is called
    //when this is called, we will need the database var
    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            WishDatabase::class.java,
            "wishlist.db"
        ).build()
    }
}