package com.whatrushka.impl.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.whatrushka.api.navigation.HomeRoute
import com.whatrushka.impl.data.HomeViewModel
import com.whatrushka.impl.navigation.HomeNavigator
import com.whatrushka.impl.presentation.layout.HomeLayout
import com.whatrushka.ui.components.navigation.ScaffoldWrapper

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigator: HomeNavigator,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    ScaffoldWrapper(HomeRoute, navController) {
        HomeLayout(
            viewModel,
            navigator,
            navController,
            modifier
        )
    }
}

