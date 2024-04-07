package com.whatrushka.impl.presentation.profile.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileNavigation
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileRoute
import com.whatrushka.impl.presentation.profile.ProfileScreen
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class ProfileNavigationImpl : ProfileNavigation {

    override val route = ProfileRoute
    override fun navigate(navController: NavController) {
        navController.navigate(route.path()){
            launchSingleTop = true
        }
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val profileNavigator: ProfileNavigator = koinInject { parametersOf(navController) }

            ProfileScreen(profileNavigator, navController, modifier)
        }
    }
}