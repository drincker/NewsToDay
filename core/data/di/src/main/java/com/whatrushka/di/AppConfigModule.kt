package com.whatrushka.di

import androidx.datastore.core.Serializer
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.appconfig.models.AppConfig
import com.whatrushka.impl.appconfig.AppConfigServiceImpl
import com.whatrushka.impl.appconfig.models.AppConfigSerializer
import org.koin.dsl.module

val appConfigModule = module {
    single<Serializer<AppConfig>> { AppConfigSerializer }

    single<AppConfigService> { AppConfigServiceImpl(get(), get()) }
}