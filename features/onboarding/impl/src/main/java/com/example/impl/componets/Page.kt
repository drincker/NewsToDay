package com.example.impl.componets

import androidx.annotation.DrawableRes
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