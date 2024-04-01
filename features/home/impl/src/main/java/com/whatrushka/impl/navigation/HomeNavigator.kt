package com.whatrushka.impl.navigation

import androidx.navigation.NavController
import com.whatrushka.api.models.Article
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.navigation.BaseNavigator

class HomeNavigator(
    private val navController: NavController,
    private val articleNavigation: ArticleNavigation
) : BaseNavigator(navController) {

    fun navigateToArticle(article: Article) =
        articleNavigation.navigate(navController, article)

}