package com.whatrushka.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.navigation.BookmarksRoute
import com.whatrushka.api.navigation.HomeRoute
import com.whatrushka.core.ui.R
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileRoute
import com.whatrushka.navigation.Route

val NavItems = listOf<NavigationItem>(
    NavigationItem(
        route = HomeRoute,
        icon = R.drawable.icon_home_screen
    ),
    NavigationItem(
        route = object : Route("categories") {},
        icon = R.drawable.icon_categories_screen
    ),
    NavigationItem(
        route = BookmarksRoute,
        icon = R.drawable.icon_bookmarks_screen
    ),
    NavigationItem(
        route = ProfileRoute,
        icon = R.drawable.icon_profile_screen
    ),
)

@Composable
fun ScaffoldWrapper(
    screenRoute: Route,
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit,
) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navItems = NavItems,
                currentRoute = screenRoute
            ) {
                navController.navigate(it.path())
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
