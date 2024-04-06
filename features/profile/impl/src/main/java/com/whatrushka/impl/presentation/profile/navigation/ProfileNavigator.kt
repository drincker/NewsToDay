package com.whatrushka.impl.presentation.profile.navigation

import androidx.navigation.NavController
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.navigation.BaseNavigator

class ProfileNavigator(
    private val navController: NavController,
    private val tacNavigation: TACNavigation
) : BaseNavigator(navController) {

    fun navigateToTermsAndConditions(navController: NavController) {
        tacNavigation.navigate(navController)
    }

}