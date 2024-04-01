package com.whatrushka.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.api.navigation.HomeNavigation
import com.whatrushka.api.navigation.HomeRoute
import com.whatrushka.impl.data.HomeViewModel
import com.whatrushka.impl.presentation.HomeScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class HomeNavigationImpl : HomeNavigation {

    override val route = HomeRoute

    override fun navigate(navController: NavController) =
        navController.navigate(route.path())

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val homeViewModel: HomeViewModel = koinViewModel()
            val homeNavigator: HomeNavigator = koinInject { parametersOf(navController) }

            HomeScreen(homeViewModel, homeNavigator, modifier)
        }
    }

}