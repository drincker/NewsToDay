package com.whatrushka.impl

import com.whatrushka.api.ApiService
import com.whatrushka.api.models.NewsResponse
import com.whatrushka.api.models.static.Category
import com.whatrushka.api.models.static.Language
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceImpl(
    private val client: HttpClient,
    private val apiKey: String
) : ApiService {

    companion object {
        private const val API = "https://newsapi.org/v2"
        private const val EVERYTHING = "$API/everything"
        private const val TOP_HEADLINES = "$API/top-headlines"
    }

    override suspend fun getNews(
        q: String,
        language: Language,
        page: Int,
        pageSize: Int
    ) = client.get(EVERYTHING) {
        url.parameters.apply {
            append("apiKey", apiKey)
            append("q", q)
            append(Language.ApiName, language.name)
            append("page", page.toString())
            append("pageSize", pageSize.toString())
        }
    }.body<NewsResponse>()

    override suspend fun getTopHeadlines(
        q: String?,
        language: Language,
        category: Category?,
        page: Int,
        pageSize: Int
    ) = client.get(TOP_HEADLINES) {
        url.parameters.apply {
            append("apiKey", apiKey)
            q?.let { append("q", it) }
            append(Language.ApiName, language.name)
            if (category !is Category.All && category != null)
                append(Category.ApiName, category.name)
            append("page", page.toString())
            append("pageSize", pageSize.toString())
        }
    }.body<NewsResponse>()
}