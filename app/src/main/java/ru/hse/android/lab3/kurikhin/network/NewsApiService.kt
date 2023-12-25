package ru.hse.android.lab3.kurikhin.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Query
import ru.hse.android.lab3.kurikhin.models.HttpResult

private const val API_KEY = "pub_35326a956b64b25899037076ed2d8b368b6ce"
private const val BASE_URL = "https://newsdata.io/api/1/"

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

private val mediaType = "application/json".toMediaType()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json
        .asConverterFactory(mediaType))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("news")
    suspend fun getNews(@Query("q") query: String, @Query("apikey") apiKey: String = API_KEY): HttpResult
}

object NewsApi {
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}