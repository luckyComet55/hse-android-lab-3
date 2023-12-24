package ru.hse.android.lab3.kurikhin.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.hse.android.lab3.kurikhin.models.News

@Composable
fun NewsList(
    data: List<News>,
    onListItemClick: (News) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(6.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        items(
            items = data,
            key = {n -> n.articleId}
        ) { news ->
            NewsListItem(
                news = news,
                onClick = { onListItemClick(news) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}