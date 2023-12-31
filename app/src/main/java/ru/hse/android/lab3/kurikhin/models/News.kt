package ru.hse.android.lab3.kurikhin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    @SerialName(value = "article_id")
    val articleId: String,
    val title: String,
    val link: String,
    val content: String,
    val pubDate: String,
    val description: String = "None",
    val author: String = "Anonymous"
)
