package com.whatrushka.di

import com.whatrushka.api.ApiService
import com.whatrushka.impl.ApiServiceImpl
import com.whatrushka.impl.BuildConfig
import com.whatrushka.impl.Client
import io.ktor.client.HttpClient
import org.koin.dsl.module

val newsApiModule = module {
    single<ApiService> {
        ApiServiceImpl(get(), BuildConfig.NEWS_API_KEY)
    }

    single<HttpClient> { Client }
}