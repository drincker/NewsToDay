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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import com.whatrushka.api.models.static.Category
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryBlue
import java.util.Locale

@Composable
fun Tag(
    category: Category,
    selected: Boolean,
    onClick: (Category) -> Unit
) {
    Box(
        Modifier
            .background(PrimaryBlue)
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        Text(category.name.replaceFirstChar { it.uppercaseChar() },
            color = Color.White,
            style = NewsToDayType.Common
        )
    }
}