package com.whatrushka.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryBlue
import com.whatrushka.ui.theme.SecondaryGrey

@Composable
fun ScreenAppBar(
    title: String,
    description: String?
) {
    Column {
        Text(text = title,
            color = PrimaryBlue,
            style = NewsToDayType.TitleLarge
        )

        description?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it,
                color = SecondaryGrey,
                style = NewsToDayType.Common
            )
        }
    }
}