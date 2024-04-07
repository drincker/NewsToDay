package com.whatrushka.impl.appbookmarks

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.whatrushka.api.appbookmarks.AppArticlesService
import com.whatrushka.api.appbookmarks.models.Articles
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class AppArticlesServiceImpl(
    private val context: Context,
    serializer: Serializer<Articles>
) : AppArticlesService {
    private val Context.appArticlesDataStore by dataStore("app-articles.json", serializer)

    private val appArticles: Flow<Articles>
        get() = context.appArticlesDataStore.data


    private suspend fun getAppArticles() = appArticles.first()

    override suspend fun getPinned() = getAppArticles().articles


    override suspend fun changeArticleStatus(article: Article) {
        val currentArticles = getAppArticles()
        if (article in currentArticles.articles) {
            context.appArticlesDataStore.updateData { current ->
                current.copy(articles = currentArticles.articles - article)
            }
        } else {
            context.appArticlesDataStore.updateData { current ->
                current.copy(articles = currentArticles.articles + article)
            }
        }
    }
}