package ru.hse.android.lab3.kurikhin.models

import kotlinx.serialization.Serializable

@Serializable
data class HttpResult (
    val results: List<News>
)