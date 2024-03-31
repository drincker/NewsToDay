package com.whatrushka.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey

@Composable
fun ScreenAppBar(
    title: String,
    description: String?
) {
    Column {
        Text(
            text = title,
            color = Color.Black,
            style = NewsToDayType.TitleLarge
        )

        description?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = it,
                color = PrimaryGrey,
                style = NewsToDayType.Common
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}