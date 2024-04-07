package com.whatrushka.navigation

abstract class Route(
    private val path: String,
) {
    fun path(): String = path
}