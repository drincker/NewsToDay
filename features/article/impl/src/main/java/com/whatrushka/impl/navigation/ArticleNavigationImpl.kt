package com.whatrushka.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.models.Article
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.api.navigation.ArticleRoute
import com.whatrushka.impl.presentation.ArticleScreen
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class ArticleNavigationImpl : ArticleNavigation {
    override val route = ArticleRoute

    override fun navigate(navController: NavController, article: Article) = with(navController) {
        currentBackStackEntry?.savedStateHandle?.let {
            it[ArticleRoute.KEYS.ARTICLE] = article
        }
        navigate(route.path()) {
            launchSingleTop = true
        }
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            val articleNavigator: ArticleNavigator = koinInject { parametersOf(navController) }
            val appConfigService: AppConfigService = koinInject()
            navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<Article>(ArticleRoute.KEYS.ARTICLE)
                ?.let {

                    ArticleScreen(it, articleNavigator, appConfigService, modifier)
                }
        }
    }
}