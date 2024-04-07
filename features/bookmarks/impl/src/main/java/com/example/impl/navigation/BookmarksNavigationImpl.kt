package com.example.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.impl.presentation.BookmarksScreen
import com.example.navigation.BookmarksNavigation
import com.example.navigation.BookmarksRoute
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.navigation.Route
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class BookmarksNavigationImpl : BookmarksNavigation {
    override val route: Route
        get() = BookmarksRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val appConfigService: AppConfigService = koinInject()
            val bookmarksNavigator: BookmarksNavigator = koinInject { parametersOf(navController) }

            BookmarksScreen(navController, appConfigService, bookmarksNavigator, modifier)
        }
    }

}