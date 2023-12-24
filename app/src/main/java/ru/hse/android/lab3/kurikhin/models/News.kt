package ru.hse.android.lab3.kurikhin.models

import java.util.Date

data class News(
    val articleId: String,
    val title: String,
    val link: String,
    val description: String,
    val content: String,
    val pubDate: Date,
    val country: ArrayList<String>,
    val category: ArrayList<String>,
    val author: String
)
