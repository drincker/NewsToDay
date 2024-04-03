package com.whatrushka.ui.components.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.whatrushka.api.navigation.HomeRoute
import com.whatrushka.core.ui.R

val NavItems = listOf<NavigationItem>(
    NavigationItem(
        route = HomeRoute,
        icon = R.drawable.icon_home_screen
    ),
//    NavigationItem(
//        route = CategoriesRoute,
//        icon = R.drawable.icon_categories_screen
//    NavigationItem(
//        route = BookmarksRoute,
//        icon = R.drawable.icon_bookmarks_screen
//    ),
//    NavigationItem(
//        route = ProfileRoute,
//        icon = R.drawable.icon_profile_screen
//    ),
)

@Composable
fun ScaffoldWrapper(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route?.substringBefore("/")

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navItems = NavItems,
                currentRoute = currentRoute
            ) {

                Log.d("m", it.toString())
                navController.navigate(it.path()) {
                    popUpTo(navController.graph.id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
    ) { paddingValues ->
        Box(
            Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            content(paddingValues)
        }
    }
}
