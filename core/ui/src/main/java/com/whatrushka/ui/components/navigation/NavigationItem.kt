package com.whatrushka.ui.components.navigation

import androidx.annotation.DrawableRes
import com.whatrushka.navigation.Route

data class NavigationItem(
    val route: Route,
    @DrawableRes val icon: Int
)
