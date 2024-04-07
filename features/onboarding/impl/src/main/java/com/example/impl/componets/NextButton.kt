package com.example.impl.componets



import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.impl.navigation.OnboardingNavigator
import com.exemple.impl.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NextButton(
    pagerState: PagerState,
    pages: List<Page>,
    navigator: OnboardingNavigator,
    navController: NavHostController
){
    val scope: CoroutineScope = rememberCoroutineScope()
    val isLastPage = pagerState.currentPage == pages.size - 1
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp),
            onClick = { if (isLastPage) {
                navigator.navigateToHome(navController)
            } else {
                scope.launch{ pagerState.animateScrollToPage(pagerState.currentPage + 1) }
            } }
        ) {
            Text(
                text = if (isLastPage) stringResource(R.string.button_get_started)
                else stringResource(R.string.button_next)
            )
        }
    }
}