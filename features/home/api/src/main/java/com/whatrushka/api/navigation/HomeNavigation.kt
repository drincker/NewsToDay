package com.whatrushka.api.navigation

import androidx.navigation.NavController
import com.whatrushka.navigation.FeatureNavigation

interface HomeNavigation : FeatureNavigation {
    fun navigate(navController: NavController)
}