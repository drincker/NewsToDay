package com.whatrushka.bookmarks.di

import com.example.impl.navigation.BookmarksNavigationImpl
import com.example.impl.navigation.BookmarksNavigator
import com.example.navigation.BookmarksNavigation
import org.koin.dsl.module

val bookmarksModule = module {

    single<BookmarksNavigation> { BookmarksNavigationImpl() }

    single<BookmarksNavigator> { navController -> BookmarksNavigator(navController.get(), get()) }

}