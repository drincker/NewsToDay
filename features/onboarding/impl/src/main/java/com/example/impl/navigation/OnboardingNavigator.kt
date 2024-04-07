package com.example.impl.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.whatrushka.api.navigation.HomeNavigation
import com.whatrushka.navigation.BaseNavigator

class OnboardingNavigator(
    private val navController: NavController,
    private val homeNavigation: HomeNavigation
    ) : BaseNavigator(navController) {
    fun navigateToHome(navHostController: NavHostController ) =
        homeNavigation.navigate(navHostController)
}