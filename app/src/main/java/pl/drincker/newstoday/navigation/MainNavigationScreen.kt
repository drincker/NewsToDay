package pl.drincker.newstoday.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.api.navigation.HomeNavigation
import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileNavigation
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.navigation.registerFeature
import org.koin.compose.koinInject

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigationScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    val homeFeature: HomeNavigation = koinInject()
    val categoriesFeature: HomeNavigation = koinInject()
    val bookmarksFeature: HomeNavigation = koinInject()
    val profileFeature: ProfileNavigation = koinInject()
    val tacFeature: TACNavigation = koinInject()
    val articleFeature: ArticleNavigation = koinInject()

    NavHost(
        navController,
        startDestination = homeFeature.route.path(), // TODO: Add Welcome Check
    ) {
        registerFeature(homeFeature, navController, modifier)
        registerFeature(categoriesFeature, navController, modifier)
        registerFeature(bookmarksFeature, navController, modifier)
        registerFeature(tacFeature, navController, modifier)
        registerFeature(profileFeature, navController, modifier)
        registerFeature(articleFeature, navController, modifier)
    }


}