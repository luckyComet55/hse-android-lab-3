package ru.hse.android.lab3.kurikhin.ui.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.hse.android.lab3.kurikhin.models.News
import ru.hse.android.lab3.kurikhin.network.NewsApi
import java.io.IOException

sealed interface NewsUiState {
    data class Success(val news: List<News>) : NewsUiState
    object Loading : NewsUiState
    object Error : NewsUiState
}


class MainScreenViewModel : ViewModel() {
    
    init {
        getNews("football")
    }
    
    var newsListState: NewsUiState by mutableStateOf(NewsUiState.Loading)
        private set
    private fun getNews(queryParams: String) {
        viewModelScope.launch {
            newsListState = try {
                val httpResult = NewsApi.retrofitService.getNews(queryParams)
                NewsUiState.Success(httpResult.results)
            } catch (e: IOException) {
                NewsUiState.Error
            } catch (e: HttpException) {
                NewsUiState.Error
            }
        }
    }
}
