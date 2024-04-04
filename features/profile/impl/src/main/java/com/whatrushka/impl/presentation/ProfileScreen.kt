package com.whatrushka.impl.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.whatrushka.faetures.profile.api.navigatoin.ProfileRoute
import com.whatrushka.impl.presentation.layout.ProfileLayout
import com.whatrushka.ui.components.navigation.ScaffoldWrapper

@Composable
fun ProfileScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    ScaffoldWrapper(ProfileRoute, navController) {
        ProfileLayout(
            navController,
            modifier.padding(it)
        )
    }
}