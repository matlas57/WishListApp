package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//indicate to room that we want Wish entries in a table 'wish_table'. Each wish indicates a new record with properties being the values of this class
@Entity(tableName = "wish_table")
data class Wish(
    @PrimaryKey(autoGenerate = true) //set the primary key to the key that will be unique to each entry
    val id: Long = 0L,
    @ColumnInfo(name = "wish_title") //define the column name for Wish titles
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title="Google Watch 2", description = "Android watch"),
        Wish(title="New book", description = "Sci-fi"),
        Wish(title="Mega car", description = "vroom vroom")
    )
}