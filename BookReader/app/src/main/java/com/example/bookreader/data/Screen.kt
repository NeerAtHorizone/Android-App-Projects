package com.example.bookreader.data

sealed class Screen (val route : String) {
    object Home : Screen("home")
    object OnLaunch : Screen("Launch Screen")
}