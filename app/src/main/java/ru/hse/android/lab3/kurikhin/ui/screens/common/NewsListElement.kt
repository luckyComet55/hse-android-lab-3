package ru.hse.android.lab3.kurikhin.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.hse.android.lab3.kurikhin.models.News
import ru.hse.android.lab3.kurikhin.R
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListItem(
    news: News,
    isInFavourites: Boolean,
    onClick: () -> Unit,
    onFavClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier,
        onClick = onClick,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onFavClick,
                ) {
                    Icon(
                        imageVector =
                            if (isInFavourites)
                                Icons.Filled.Favorite
                            else
                                Icons.Filled.FavoriteBorder,
                        contentDescription =
                            if (isInFavourites)
                                stringResource(id = R.string.rm_from_fav)
                            else
                                stringResource(id = R.string.add_to_fav)
                    )
                }
            }
            Text(
                text = news.description,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = news.content,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = news.author,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = news.pubDate.toString(),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview
@Composable
private fun NewsListItemPreview() {
    NewsListItem(
        news = News(
            "1212",
            "Title check",
            "localhost",
            "Today I gotta finish this",
            "So a few days ago I was walking down the Porkovskaya street and I saw this one guy",
            Date(System.currentTimeMillis()),
            arrayListOf("russia"),
            arrayListOf(""),
            "Me"
        ),
        onClick = {},
        onFavClick = {},
        isInFavourites = false,
    )
}