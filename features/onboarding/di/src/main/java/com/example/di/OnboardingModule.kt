package com.example.di

import com.example.api.navigation.OnboardingNavigation
import com.example.impl.navigation.OnboardingNavigationImpl
import com.example.impl.navigation.OnboardingNavigator
import org.koin.dsl.module

val onboardingModule = module {

    single<OnboardingNavigation> { OnboardingNavigationImpl() }

    single<OnboardingNavigator> { navController -> OnboardingNavigator(navController.get(), get()) }

}