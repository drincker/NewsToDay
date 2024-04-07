package com.whatrushka.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavController

abstract class BaseNavigator(
    private val navController: NavController
) {
    @SuppressLint("RestrictedApi")
    fun onBackButtonClick() {
        navController.popBackStack()
    }
}