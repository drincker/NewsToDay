package com.whatrushka.features.profile.di

import com.whatrushka.faetures.profile.api.navigatoin.ProfileNavigation
import com.whatrushka.impl.navigation.ProfileNavigationImpl
import org.koin.dsl.module

val profileModule = module {

    single<ProfileNavigation> { ProfileNavigationImpl() }

}