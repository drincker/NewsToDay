package com.whatrushka.api

import com.whatrushka.api.models.NewsResponse
import com.whatrushka.api.models.static.Category
import com.whatrushka.api.models.static.Language

interface ApiService {

    suspend fun getTopHeadlines(
        language: Language = Language.RU,
        category: Category? = null,
    ): NewsResponse

    suspend fun getNews(
        q: String,
        language: Language = Language.RU,
        page: Int = 1,
        pageSize: Int = 20
    ): NewsResponse

}