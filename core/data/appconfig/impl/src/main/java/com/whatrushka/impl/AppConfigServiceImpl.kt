package com.whatrushka.impl

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.whatrushka.api.models.AppConfig
import com.whatrushka.api.models.static.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class AppConfigServiceImpl(
    private val context: Context,
    serializer: Serializer<AppConfig>
) {
    private val Context.appConfigDataStore by dataStore("app-config.json", serializer)

    private val appConfig: Flow<AppConfig>
        get() = context.appConfigDataStore.data

    suspend fun getAppConfig() = appConfig.first()

    suspend fun updateAppConfig(language: Language) {
        context.appConfigDataStore.updateData {
            AppConfig(language = language)
        }
    }

}