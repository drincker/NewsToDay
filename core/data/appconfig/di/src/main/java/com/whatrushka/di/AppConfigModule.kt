package com.whatrushka.di

import androidx.datastore.core.Serializer
import com.whatrushka.api.models.AppConfig
import com.whatrushka.impl.AppConfigServiceImpl
import com.whatrushka.impl.models.AppConfigSerializer
import org.koin.dsl.module

val appConfigModule = module {
    single<AppConfigServiceImpl> { AppConfigServiceImpl(get(), get()) }

    single<Serializer<AppConfig>> { AppConfigSerializer }
}