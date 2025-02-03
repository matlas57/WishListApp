package com.example.wishlistapp

import android.app.Application

//Application class is a good place for creating global state required throughout an application
//Application classes much be mentioned in the manifest
class WishListApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Graph.provide(this) //the wishlist app is the context needed to create the database
    }
}