package com.example.impl

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.impl.componets.ButtonNextOrGetStarted
import com.example.impl.componets.PageIndicator
import com.example.impl.componets.SinglePage
import com.example.impl.componets.pages


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreen() {
    val pagerState: PagerState = rememberPagerState (0, pageCount = { pages.size })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp)
        ) {
            index -> SinglePage(page = pages[index])
        }
        Spacer(modifier = Modifier.size(16.dp))

        ButtonNextOrGetStarted(pagerState = pagerState)
        Spacer(modifier = Modifier.size(16.dp))
        PageIndicator(
            pagerState = pagerState,
            pageCount = pages.size
        )
    }
}

