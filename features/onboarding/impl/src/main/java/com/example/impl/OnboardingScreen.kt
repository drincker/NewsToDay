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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.impl.componets.NextButton
import com.example.impl.componets.Page
import com.example.impl.componets.PageIndicator
import com.example.impl.componets.SinglePage
import com.example.impl.navigation.OnboardingNavigator
import com.exemple.impl.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navigator: OnboardingNavigator,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val pages: List<Page> = listOf(
        Page(
            title = stringResource(R.string.welcome_title),
            description = stringResource(R.string.welcome_description),
            image = R.drawable.welcome
        ),
        Page(
            title = stringResource(R.string.main_title),
            description = stringResource(R.string.main_description),
            image = R.drawable.main
        ),
        Page(
            title = stringResource(R.string.categories_title),
            description = stringResource(R.string.categories_description),
            image = R.drawable.categories
        ),
        Page(
            title = stringResource(R.string.bookmarks_title),
            description = stringResource(R.string.bookmarks_description),
            image = R.drawable.bookmarks
        ),
        Page(
            title = stringResource(R.string.profile_title),
            description = stringResource(R.string.profile_description),
            image = R.drawable.profile
        )
    )

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

        NextButton(
            pagerState = pagerState,
            pages = pages,
            modifier = modifier,
            navigator = navigator,
            navController = navController
        )
        Spacer(modifier = Modifier.size(16.dp))
        PageIndicator(
            pagerState = pagerState,
            pageCount = pages.size
        )
    }
}

