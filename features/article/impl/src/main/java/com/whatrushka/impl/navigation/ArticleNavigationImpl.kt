package com.whatrushka.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.api.models.Article
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.api.navigation.ArticleRoute
import com.whatrushka.impl.presentation.ArticleScreen

class ArticleNavigationImpl : ArticleNavigation {
    override val route = ArticleRoute

    override fun navigate(navController: NavController, article: Article) = with(navController) {
        currentBackStackEntry?.savedStateHandle?.set(ArticleRoute.KEYS.ARTICLE, article)
        navigate(route.path())
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.path()) {
            navController.currentBackStackEntry?.savedStateHandle
                ?.get<Article>(ArticleRoute.KEYS.ARTICLE)?.let {
                    ArticleScreen(it)
                }
        }
    }
}