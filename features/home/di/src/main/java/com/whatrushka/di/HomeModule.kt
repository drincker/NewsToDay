package com.whatrushka.di

import com.whatrushka.api.data.FilterService
import com.whatrushka.impl.data.FilterServiceImpl
import com.whatrushka.impl.data.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<FilterService> { FilterServiceImpl() }

    viewModel { HomeViewModel(get(), get(), get()) }
}