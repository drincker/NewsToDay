package com.whatrushka.impl.appconfig

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.appconfig.models.AppConfig
import com.whatrushka.api.models.static.Category
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

    private suspend fun getAppConfig() = appConfig.first()

    override suspend fun setLanguage(language: Language) {
        context.appConfigDataStore.updateData {
            getAppConfig().copy(language = language)
        }
    }

    override suspend fun isWelcome() =
        getAppConfig().isWelcome

    override suspend fun setIsWelcome(isWelcome: Boolean) {
        context.appConfigDataStore.updateData {
            getAppConfig().copy(isWelcome = isWelcome)
        }
    }
    
    override suspend fun getConfiguredLanguage() =
        getAppConfig().language

    override fun getLanguages() = Language.list()

    override suspend fun setFavoritesCategories(categories: Set<Category>) {
        context.appConfigDataStore.updateData {
            getAppConfig().copy(favoriteCategories = categories)
        }
    }

    override suspend fun getFavoritesCategories() =
        getAppConfig().favoriteCategories

    override fun getCategories() = Category.list()

}