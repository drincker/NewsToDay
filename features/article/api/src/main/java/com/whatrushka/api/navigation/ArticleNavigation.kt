package com.whatrushka.api.navigation

import androidx.navigation.NavController
import com.whatrushka.api.models.Article
import com.whatrushka.navigation.FeatureNavigation

interface ArticleNavigation : FeatureNavigation {
    fun navigate(navController: NavController, article: Article)
}