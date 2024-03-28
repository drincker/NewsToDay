package com.whatrushka.impl.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.whatrushka.api.ApiService
import com.whatrushka.api.models.Article
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val apiService: ApiService,
//    private val filterService: FilterService,
    private val appConfigService: AppConfigService
) : ViewModel(), KoinComponent {

    private val _news = mutableListOf<Article>()

    fun fetchNews

}