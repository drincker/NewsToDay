package com.whatrushka.impl.presentation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.whatrushka.core.ui.R
import com.whatrushka.impl.presentation.components.SettingBox
import com.whatrushka.ui.components.ScreenAppBar
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey


@Composable
fun ProfileLayout(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier) {

        ScreenAppBar(title = "Profile", description = null)

        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Row(
                    Modifier.height(IntrinsicSize.Min)
                ) {
                    Image(
                        painter = painterResource(
                            com.whatrushka.features.profile.impl.R.drawable.profile_icon
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(50))
                    )

                    Spacer(Modifier.width(16.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "John Doe",
                            style = NewsToDayType.SemiCommon,
                            color = Color.Black
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "johndoe@gmail.com",
                            style = NewsToDayType.SemiCommon,
                            color = Color(0xFFB1B1B1)
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                SettingBox(
                    icon = R.drawable.icon_arrow_select
                ) {
                    Text(
                        text = "Language",
                        color = PrimaryGrey
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                SettingBox(
                    icon = R.drawable.icon_arrow_select
                ) {
                    Text(
                        text = "Terms & Conditions",
                        color = PrimaryGrey
                    )
                }

                Spacer(Modifier.height(16.dp))

                SettingBox(
                    icon = R.drawable.icon_logout
                ) {
                    Text(
                        text = "Sign Out",
                        color = PrimaryGrey
                    )
                }
            }
        }
    }
}