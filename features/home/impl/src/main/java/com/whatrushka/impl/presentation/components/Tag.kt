package com.whatrushka.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.whatrushka.api.models.static.Category
import com.whatrushka.ui.theme.LightGrey
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryBlue
import com.whatrushka.ui.theme.PrimaryGrey

@Composable
fun Tag(
    category: Category,
    selected: Category,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (category == selected) PrimaryBlue else LightGrey
            )
            .padding(16.dp, 10.dp)

    ) {
        Text(
            category.name.replaceFirstChar { it.uppercaseChar() },
            color = if (category == selected) Color.White else PrimaryGrey,
            style = NewsToDayType.Common
        )
    }
}