package com.whatrushka.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.whatrushka.core.ui.R
import com.whatrushka.navigation.BaseNavigator
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey

@Composable
fun ScreenAppBar(
    title: String,
    description: String?,
    navigator: BaseNavigator? = null
) {

    Log.d("m", title)

    Box(
        Modifier
            .fillMaxWidth()
            .padding(8.dp, 16.dp)
    ) {
        navigator?.let {
            Icon(
                painter = painterResource(R.drawable.icon_arrow_lite_back),
                contentDescription = null,
                tint = PrimaryGrey,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        it.onBackButtonClick()
                    }
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = if (navigator == null) Alignment.Start
            else Alignment.CenterHorizontally,
            modifier = Modifier.align(
                if (navigator == null) Alignment.CenterStart
                else Alignment.Center
            )
        ) {
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
        }
    }


}