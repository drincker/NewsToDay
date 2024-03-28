package com.whatrushka.impl

import com.whatrushka.api.ApiRepository
import com.whatrushka.api.ApiService
import com.whatrushka.api.AppConfigService
import com.whatrushka.api.models.static.Category

class ApiRepositoryImpl(
    private val api: ApiService,
    private val appConfigService: AppConfigService
    // private val newsFilterService: NewsFilterService
) : ApiRepository {
    override suspend fun getNews(
        q: String,
        page: Int,
        pageSize: Int
    ) = api.getNews(
        q,
        appConfigService.getAppConfig().language,
        page,
        pageSize
    )

    override suspend fun getTopHeadlines(
        category: Category?
    ) = api.getTopHeadlines(
        appConfigService.getAppConfig().language,
        category // newsFilterService.getFilter().category
    )
}