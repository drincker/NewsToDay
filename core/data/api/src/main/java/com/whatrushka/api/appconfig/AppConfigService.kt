package com.whatrushka.api.appconfig

import com.whatrushka.api.appconfig.models.AppConfig
import com.whatrushka.api.models.static.Language
import kotlinx.coroutines.flow.Flow

interface AppConfigService {
    suspend fun getAppConfig(): AppConfig

    suspend fun updateAppConfig(language: Language)
}