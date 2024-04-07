package com.example.impl.navigation

import androidx.navigation.NavHostController
import com.whatrushka.api.models.Article
import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.navigation.BaseNavigator

class BookmarksNavigator(
    private val navController: NavHostController,
    private val articleNavigation: ArticleNavigation
) : BaseNavigator(navController) {

    fun navigateToArticle(article: Article) {
        articleNavigation.navigate(navController, article)
    }

}