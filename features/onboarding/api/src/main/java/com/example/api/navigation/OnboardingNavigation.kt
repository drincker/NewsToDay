package com.example.api.navigation

import androidx.navigation.NavController
import com.whatrushka.navigation.FeatureNavigation

interface OnboardingNavigation : FeatureNavigation {
    fun navigate(navController: NavController)
}