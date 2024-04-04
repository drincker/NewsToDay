package com.whatrushka.ui.components.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.whatrushka.navigation.Route
import com.whatrushka.ui.theme.PrimaryBlue
import com.whatrushka.ui.theme.PrimaryGrey


@Composable
fun BottomNavigationBar(
    currentRoute: Route,
    navItems: List<NavigationItem>,
    onItemSelected: (route: Route) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        navItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    onItemSelected(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = if (currentRoute == item.route) PrimaryBlue else PrimaryGrey,
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
    }
}