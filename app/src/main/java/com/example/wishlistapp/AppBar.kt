package com.example.wishlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit)? = {
        if (!title.contains("Wish List")) {
            //Define a back button that is flipped based on direction of device language
            IconButton(
                onClick = { onBackNavClicked() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
        else {
            null
        }
    }

    TopAppBar(
        modifier = Modifier.padding(top = 50.dp),
        title = {
            Text(text = title,
                color = colorResource(id = R.color.white),
                modifier = Modifier.padding(start = 4.dp).heightIn(max = 24.dp)) //height in constrains composable height
            }, //R accesses res folder
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon
    )

}