package ru.hse.android.lab3.kurikhin.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.hse.android.lab3.kurikhin.R
import ru.hse.android.lab3.kurikhin.ui.screens.common.MainScreenTopBar
import ru.hse.android.lab3.kurikhin.ui.screens.common.NewsList

@Composable
fun MainScreen(
    newsUiState: NewsUiState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MainScreenTopBar(
                title = stringResource(id = R.string.main_screen_title),
                showNavButton = false,
                onNavButtonClick = {},
                actionsBlock = {}
            )
        },
        modifier = modifier
    ) { padding ->
        Surface(modifier = Modifier.padding(padding)) {
            when (newsUiState) {
                is NewsUiState.Success -> NewsList(
                    data = newsUiState.news,
                    onListItemClick = {}
                )
                is NewsUiState.Loading -> LoadingBody(
                    Modifier.fillMaxSize()
                )
                is NewsUiState.Error -> ErrorBody(
                    Modifier.fillMaxSize()
                )
            }
            
        }
    }
}

@Composable
fun LoadingBody(modifier: Modifier = Modifier) {
    Text(
        text = "Loading...",
        modifier = modifier
    )
}

@Composable
fun ErrorBody(modifier: Modifier = Modifier) {
    Text(
        text = "Error!!!",
        modifier = modifier
    )
}
