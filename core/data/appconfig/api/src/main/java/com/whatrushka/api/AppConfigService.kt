package com.whatrushka.api

import android.content.Context
import com.whatrushka.api.models.AppConfig
import com.whatrushka.api.models.static.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

interface AppConfigService {
    val appConfig: Flow<AppConfig>

    suspend fun getAppConfig(): AppConfig

    suspend fun updateAppConfig(language: Language)

}