package com.whatrushka.impl.data

import androidx.compose.runtime.mutableStateOf
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
    val filterService: FilterService,
    private val appConfigService: AppConfigService
) : ViewModel(), KoinComponent {

    companion object {
        const val PAGE_SIZE = 10
    }

    private val _news = mutableStateOf(emptyList<Article>())
    fun getNewsAsState() = _news

    private var pagination = 1
    private var lastCall = LastCall()

    private val _q = mutableStateOf("")

    fun getQAsState() = _q

    fun setQ(q: String) {
        _q.value = q
    }

    fun selectCategory(category: Category) {
        filterService.selectCategory(category)
        getNews()
    }

    fun changeArticleFlag(article: Article) {
        viewModelScope.launch {
            appConfigService.changeArticleFlag(article)
        }
    }

    fun getNews() {
        viewModelScope.launch {
            val articles = mutableListOf<Article>()
            val selectedCategory = filterService.getSelectedCategory()

            articles.addAll(
                apiService.getTopHeadlines(
                    q = _q.value,
                    language = appConfigService.getConfiguredLanguage(),
                    category = selectedCategory,
                    pageSize = PAGE_SIZE,
                    page = pagination++
                )
            )

            val newLastCall = LastCall(_q.value, filterService.getSelectedCategory())

            if (lastCall != newLastCall)
                lastCall = newLastCall
            _news.value = emptyList()

            _news.value += articles
        }
    }
}