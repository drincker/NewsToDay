package com.whatrushka.impl.appconfig

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.appconfig.models.AppConfig
import com.whatrushka.api.models.static.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class AppConfigServiceImpl(
    private val context: Context,
    serializer: Serializer<AppConfig>
) : AppConfigService {
    private val Context.appConfigDataStore by dataStore("app-config.json", serializer)

    private val appConfig: Flow<AppConfig>
        get() = context.appConfigDataStore.data

    override suspend fun getAppConfig() = appConfig.first()

    override suspend fun updateAppConfig(language: Language) {
        context.appConfigDataStore.updateData {
            AppConfig(language = language)
        }
    }

}