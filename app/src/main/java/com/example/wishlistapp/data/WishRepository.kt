package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

//Create a repository as a layer between the database and the viewModel. Creating a clean API robust to updates in how data is retrieved
class WishRepository(private val wishDao: WishDao) {
    suspend fun addWish(wish: Wish) {
        wishDao.addWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Long): Flow<Wish> = wishDao.getWishById(id)

    suspend fun updateWish(wish: Wish) {
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish) {
        wishDao.deleteWish(wish)
    }
}