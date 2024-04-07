package com.whatrushka.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.faetures.profile.api.navigatoin.ProfileNavigation
import com.whatrushka.faetures.profile.api.navigatoin.ProfileRoute
import com.whatrushka.impl.presentation.ProfileScreen

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
            ProfileScreen(navController, modifier)
        }
    }
}