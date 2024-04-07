package com.whatrushka.api.appbookmarks

import com.whatrushka.api.models.Article

interface AppArticlesService {

    suspend fun getPinned(): List<Article>
    suspend fun changeArticleStatus(article: Article)


}