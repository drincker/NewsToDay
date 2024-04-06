package com.whatrushka.faetures.profile.api.terms_conditions.navigation

import androidx.navigation.NavController
import com.whatrushka.navigation.FeatureNavigation

interface TACNavigation : FeatureNavigation {
    fun navigate(navController: NavController)
}