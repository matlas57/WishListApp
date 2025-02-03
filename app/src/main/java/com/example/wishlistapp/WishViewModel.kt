package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository= Graph.wishRepository
): ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }

    // lateinit allows initialization of a var outside of the constructor before the variable is used anywhere, we use it here with a flow because Flow is asynchronous
    // using lateinit allows to avoid using nullchecks
    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getAllWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) { //Dispatchers defines the threads that the coroutine runs on
            wishRepository.addWish(wish)
        }
    }

    fun getWishById(id: Long): Flow<Wish> = wishRepository.getWishById(id)

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }
}