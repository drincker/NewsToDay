package com.whatrushka.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.whatrushka.ui.theme.PrimaryBlue

@Composable
fun ArticleTag(tag: String) {
    Box(
        Modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Min)
            .clip(RoundedCornerShape(15.dp))
            .background(PrimaryBlue)

    ) {
        Text(
            text = tag,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
        )
    }
}