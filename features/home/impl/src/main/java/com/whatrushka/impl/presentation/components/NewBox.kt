package com.whatrushka.impl.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.whatrushka.api.models.Article
import com.whatrushka.ui.theme.TagLight
import pl.drincker.newstoday.R

@Composable
fun NewBox(
    article: Article,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(20.dp)
        )
        
        AsyncImage(
            contentDescription = null,
            model = article.urlToImage,
            modifier = Modifier.fillMaxSize()
        )

//        Text(text = article.title,
//            style = TagLight,
//            color = Color.White,
//            modifier = Modifier.align(Alignment.BottomStart)
//        )

        Text(text = article.title,
            style = TagLight,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )

    }
}