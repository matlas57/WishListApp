package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    //indicate that this is the insert method and define the duplicate handling strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    //A Flow is a asynchronous data stream
    @Query("Select * from `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * from `wish_table` where id=:id")
    abstract fun getWishById(id: Long): Flow<Wish>

}