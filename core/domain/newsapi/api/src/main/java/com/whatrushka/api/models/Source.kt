package com.whatrushka.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String?,
    val name: String
)