package com.example.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

//configure the database
@Database(
    entities = [Wish::class], //indicate that the entries are instances of the wish data class which has the @Entity annotation
    version = 1,
    exportSchema = false
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}