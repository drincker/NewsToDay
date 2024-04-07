package com.whatrushka.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.registerFeature(
    featureNavigation: FeatureNavigation,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    featureNavigation.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}