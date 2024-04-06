package com.whatrushka.impl.presentation.terms_conditions.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACRoute
import com.whatrushka.impl.presentation.terms_conditions.TermsAndConditionsScreen
import com.whatrushka.navigation.Route
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class TACNavigationImpl : TACNavigation {
    override val route: Route
        get() = TACRoute

    override fun navigate(navController: NavController) {
        navController.navigate(route.path())
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val navigator: TACNavigator = koinInject { parametersOf(navController) }

            TermsAndConditionsScreen(navigator, modifier)
        }
    }
}