package ru.hse.android.lab3.kurikhin.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import ru.hse.android.lab3.kurikhin.models.News

private const val API_KEY = ""
private const val BASE_URL = "https://newsdata.io/api/1/news"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("/")
    suspend fun getNews(query: String): ArrayList<News>
}

object NewsApi {
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}