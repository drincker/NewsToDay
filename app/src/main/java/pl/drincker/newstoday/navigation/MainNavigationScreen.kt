package pl.drincker.newstoday.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.api.navigation.OnboardingNavigation
import com.example.api.navigation.OnboardingRoute
import com.example.navigation.BookmarksNavigation
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.api.navigation.HomeNavigation
import com.whatrushka.api.navigation.HomeRoute
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileNavigation
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.navigation.registerFeature
import org.koin.compose.koinInject

@Composable
fun MainNavigationScreen(
    isWelcome: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val homeFeature: HomeNavigation = koinInject()
    val bookmarksFeature: BookmarksNavigation = koinInject()
    val profileFeature: ProfileNavigation = koinInject()
    val tacFeature: TACNavigation = koinInject()
    val articleFeature: ArticleNavigation = koinInject()
    val onboardingFeature: OnboardingNavigation = koinInject()


    NavHost(
        navController,
        startDestination = if (isWelcome) OnboardingRoute.path()
        else HomeRoute.path(),
    ) {
        registerFeature(homeFeature, navController, modifier)
        registerFeature(bookmarksFeature, navController, modifier)
        registerFeature(tacFeature, navController, modifier)
        registerFeature(profileFeature, navController, modifier)
        registerFeature(articleFeature, navController, modifier)
        registerFeature(onboardingFeature, navController, modifier)
    }


}