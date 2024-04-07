package com.whatrushka.features.profile.di

import com.whatrushka.faetures.profile.api.profile.navigatoin.ProfileNavigation
import com.whatrushka.faetures.profile.api.terms_conditions.navigation.TACNavigation
import com.whatrushka.impl.presentation.profile.navigation.ProfileNavigationImpl
import com.whatrushka.impl.presentation.profile.navigation.ProfileNavigator
import com.whatrushka.impl.presentation.terms_conditions.navigation.TACNavigationImpl
import com.whatrushka.impl.presentation.terms_conditions.navigation.TACNavigator
import org.koin.dsl.module

val profileModule = module {

    single<ProfileNavigator> { navController -> ProfileNavigator(navController.get(), get()) }
    single<ProfileNavigation> { ProfileNavigationImpl() }

    single<TACNavigator> { navController -> TACNavigator(navController.get()) }
    single<TACNavigation> { TACNavigationImpl() }

}