package com.whatrushka.impl.presentation.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileRoute
import com.whatrushka.impl.presentation.profile.layout.ProfileLayout
import com.whatrushka.impl.presentation.profile.navigation.ProfileNavigator
import com.whatrushka.ui.components.navigation.ScaffoldWrapper

@Composable
fun ProfileScreen(
    navigator: ProfileNavigator,
    navController: NavHostController,
    appConfigService: AppConfigService,
    modifier: Modifier = Modifier
) {
    ScaffoldWrapper(ProfileRoute, navController) {
        ProfileLayout(
            navigator,
            navController,
            appConfigService,
            modifier.padding(it)
        )
    }
}