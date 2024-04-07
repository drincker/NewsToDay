package com.whatrushka.di

import com.whatrushka.api.data.FilterService
import com.whatrushka.api.navigation.HomeNavigation
import com.whatrushka.impl.data.FilterServiceImpl
import com.whatrushka.impl.data.HomeViewModel
import com.whatrushka.impl.navigation.HomeNavigationImpl
import com.whatrushka.impl.navigation.HomeNavigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<FilterService> { FilterServiceImpl() }

    single<HomeNavigation> { HomeNavigationImpl() }

    single { navController -> HomeNavigator(navController.get(), get()) }

    viewModel { HomeViewModel(get(), get(), get()) }
}