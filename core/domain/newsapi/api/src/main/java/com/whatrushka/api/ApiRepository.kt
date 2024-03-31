package com.whatrushka.api

import com.whatrushka.api.models.NewsResponse
import com.whatrushka.api.models.static.Category

interface ApiRepository {

    suspend fun getNews(
        q: String,
        page: Int,
        pageSize: Int
    ): NewsResponse

    suspend fun getTopHeadlines(
        category: Category?
    ): NewsResponse

}