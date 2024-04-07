package com.example.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.api.navigation.OnboardingNavigation
import com.example.api.navigation.OnboardingRoute
import com.example.impl.OnboardingScreen
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class OnboardingNavigationImpl : OnboardingNavigation {

    override val route = OnboardingRoute

    override fun navigate(navController: NavController) =
        navController.navigate(route.path()) {
            launchSingleTop = true
            popUpTo(0)
        }
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val onboardingNavigator: OnboardingNavigator = koinInject { parametersOf(navController) }

            OnboardingScreen(onboardingNavigator, navController)
        }
    }

}