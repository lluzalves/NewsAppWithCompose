package com.daniel.domain.entity

import java.text.SimpleDateFormat
import java.util.Locale

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)