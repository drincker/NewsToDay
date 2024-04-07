package com.whatrushka.impl.presentation.profile.navigation

import androidx.navigation.NavController
import com.example.api.navigation.OnboardingNavigation
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.navigation.BaseNavigator

class ProfileNavigator(
    private val navController: NavController,
    private val tacNavigation: TACNavigation,
    private val onboardingNavigation: OnboardingNavigation
) : BaseNavigator(navController) {

    fun navigateToWelcome(navController: NavController) {
        onboardingNavigation.navigate(navController)
    }

    fun navigateToTermsAndConditions(navController: NavController) {
        tacNavigation.navigate(navController)
    }

}