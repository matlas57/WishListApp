package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(navController, viewModel)
        }
        //This composable accepts arguments to be passed to it and they are defined using navArguments
        composable(Screen.AddScreen.route+ "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ){ entry ->
            //unpack the arguments using !! and get the entry at key "id"
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddEditDetailView(id = id, viewModel, navController)
        }
    }
}