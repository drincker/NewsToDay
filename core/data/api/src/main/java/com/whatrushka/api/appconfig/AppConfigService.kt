package com.whatrushka.api.appconfig

import com.whatrushka.api.models.Article
import com.whatrushka.api.models.static.Category
import com.whatrushka.api.models.static.Language

interface AppConfigService {

    suspend fun isWelcome(): Boolean

    suspend fun setIsWelcome(isWelcome: Boolean)

    suspend fun getPinned(): List<Article>

    suspend fun changeArticleFlag(article: Article)

    suspend fun setLanguage(language: Language)

    suspend fun getConfiguredLanguage(): Language

    fun getLanguages(): List<Language>

    suspend fun setFavoritesCategories(categories: Set<Category>)

    suspend fun getFavoritesCategories(): Set<Category>

    fun getCategories(): List<Category>
}