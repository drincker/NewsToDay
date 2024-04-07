package com.example.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.BookMarksNavigation
import com.example.navigation.BookMarksRoute
import com.whatrushka.navigation.Route
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

class BookmarksNavigationImpl: BookMarksNavigation {
    override val route: Route
        get() = BookMarksRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path){
            val bookMarksModel:BookMarksNavigation= koinInject()
        }
    }

}