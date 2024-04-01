package com.example.impl.componets

import android.provider.Settings.Global.getString
import androidx.annotation.DrawableRes
import com.exemple.impl.R
val textWelcome = Pair("News ToDay", "Будьте в курсе последних событий.")
val textMain = Pair("Главный экран", "Отображение популярных новостей, поиск по запросу и категории.")
val textCategories = Pair("Категории", "Выбор категорий новостей для отображения.")
val textBookmarks = Pair("Избранное", "Добавление и удаление новостей.")
val textProfile = Pair("Личный кабинет", "Настройки пользователя и языка приложения.")
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages: List<Page> = listOf(
    Page(
        title = textWelcome.first,
        description = textWelcome.second,
        image = R.drawable.welcome
    ),
    Page(
        title = textMain.first,
        description = textMain.second,
        image = R.drawable.main
    ),
    Page(
        title = textCategories.first,
        description = textCategories.second,
        image = R.drawable.categories
    ),
    Page(
        title = textBookmarks.first,
        description = textBookmarks.second,
        image = R.drawable.bookmarks
    ),
    Page(
        title = textProfile.first,
        description = textProfile.second,
        image = R.drawable.profile
    )

)