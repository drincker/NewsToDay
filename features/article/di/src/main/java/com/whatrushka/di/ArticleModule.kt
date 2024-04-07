package com.whatrushka.di

import com.whatrushka.api.navigation.ArticleNavigation
import com.whatrushka.impl.navigation.ArticleNavigationImpl
import com.whatrushka.impl.navigation.ArticleNavigator
import org.koin.dsl.module

val articleModule = module {

    single<ArticleNavigation> { ArticleNavigationImpl() }

    single<ArticleNavigator> { navController -> ArticleNavigator(navController.get()) }

}