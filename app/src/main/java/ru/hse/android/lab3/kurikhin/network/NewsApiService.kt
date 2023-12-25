package ru.hse.android.lab3.kurikhin.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import ru.hse.android.lab3.kurikhin.models.News

private const val API_KEY = ""
private const val BASE_URL = "https://newsdata.io/api/1/news"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("/")
    suspend fun getNews(query: String): List<News>
}

object NewsApi {
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}