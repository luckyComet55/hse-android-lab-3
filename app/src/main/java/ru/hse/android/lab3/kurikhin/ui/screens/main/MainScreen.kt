package ru.hse.android.lab3.kurikhin.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.hse.android.lab3.kurikhin.R
import ru.hse.android.lab3.kurikhin.mockNews
import ru.hse.android.lab3.kurikhin.ui.screens.common.MainScreenTopBar
import ru.hse.android.lab3.kurikhin.ui.screens.common.NewsList

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
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
            NewsList(
                data = mockNews,
                onListItemClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
