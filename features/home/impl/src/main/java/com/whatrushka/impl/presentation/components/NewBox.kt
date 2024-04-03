package com.whatrushka.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.whatrushka.api.models.Article
import com.whatrushka.core.ui.R
import com.whatrushka.ui.theme.NewsToDayType


@Composable
fun NewBox(
    article: Article,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        AsyncImage(
            contentDescription = null,
            model = article.urlToImage,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.image_placeholder),
            modifier = Modifier.fillMaxSize()
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(Color(0x32000000))
        )

        Box(
            Modifier
                .fillMaxSize()
                .padding(24.dp)

        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(26.dp)
            )

            Column(
                Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = (article.category?.name ?: "Nothing About").uppercase(),
                    style = NewsToDayType.Light,
                    color = Color.White
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = article.title,
                    style = NewsToDayType.NewDescPrev,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                )
            }

        }
    }
}