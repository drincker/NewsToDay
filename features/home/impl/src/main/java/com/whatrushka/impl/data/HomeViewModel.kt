package com.whatrushka.impl.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whatrushka.api.ApiService
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.data.FilterService
import com.whatrushka.api.data.models.LastCall
import com.whatrushka.api.models.Article
import com.whatrushka.api.models.static.Category
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val apiService: ApiService,
    private val filterService: FilterService,
    private val appConfigService: AppConfigService
) : ViewModel(), KoinComponent {

    companion object {
        const val PAGE_SIZE = 10
    }

    private val _news = mutableListOf<Article>()
    fun getNewsAsState() = _news

    private var pagination = 1
    private val lastCall = LastCall()

    fun getNews(q: String) {
        viewModelScope.launch {
            val articles = mutableListOf<Article>()
            val selectedCategory = filterService.getSelectedCategory()

            var iterations = 1
            var pageSize = PAGE_SIZE

            if (selectedCategory != Category.Random) {
                iterations = PAGE_SIZE
                pageSize = 1
            }

            for (i in 1..iterations) {
                articles.addAll(
                    apiService.getTopHeadlines(
                        q = q,
                        language = appConfigService.getAppConfig().language,
                        category = selectedCategory,
                        pageSize = pageSize,
                        page = pagination++
                    ).articles
                )
            }

            if (lastCall != LastCall(q, filterService.getSelectedCategory()))
                _news.clear()

            _news.addAll(articles)
        }
    }

}