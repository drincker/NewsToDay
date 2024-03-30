package com.example.impl.componets

import androidx.compose.material3.Text



import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ButtonNextOrGetStarted(pagerState: PagerState){
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
                .padding(16.dp),
            onClick = { if (isLastPage) {
                //TODO: launch mainScreen
                exitProcess(666)
            } else {
                scope.launch{ pagerState.animateScrollToPage(pagerState.currentPage + 1) }
            } }
        ) {
            Text(
                text = if (isLastPage) "Get Started" else "Next"
            )
        }
    }
}