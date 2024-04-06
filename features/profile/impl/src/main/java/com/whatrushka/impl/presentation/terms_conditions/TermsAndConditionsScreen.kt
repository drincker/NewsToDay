package com.whatrushka.impl.presentation.terms_conditions

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.whatrushka.features.profile.impl.R
import com.whatrushka.impl.presentation.terms_conditions.navigation.TACNavigator
import com.whatrushka.ui.components.ScreenAppBar
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey


@Composable
fun TermsAndConditionsScreen(
    navigator: TACNavigator,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        ScreenAppBar(title = "Terms & Conditions", description = null, navigator)

        Text(
            text = stringResource(R.string.terms_and_conditions),
            style = NewsToDayType.Common,
            color = PrimaryGrey,
            modifier = Modifier
                .fillMaxSize()
                .scrollable(rememberScrollState(), Orientation.Vertical)
        )
    }


}