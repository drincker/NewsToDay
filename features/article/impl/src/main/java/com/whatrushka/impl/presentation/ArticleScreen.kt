package com.whatrushka.impl.presentation

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.models.Article
import com.whatrushka.core.ui.R
import com.whatrushka.impl.navigation.ArticleNavigator
import com.whatrushka.impl.presentation.components.ArticleTag
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey
import kotlinx.coroutines.launch

@Composable
fun ArticleScreen(
    article: Article,
    navigator: ArticleNavigator,
    appConfigService: AppConfigService,
    modifier: Modifier = Modifier
) {
    val requestedUrl = remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val openLinkLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

    LaunchedEffect(requestedUrl.value) {
        requestedUrl.value?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
            if (intent.resolveActivity(context.packageManager) != null) {
                openLinkLauncher.launch(intent)
            } else {
                uriHandler.openUri(it)
            }
        }
    }

    val scrollState = rememberScrollState()

    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            AsyncImage(
                contentDescription = null,
                model = article.urlToImage,
                placeholder = painterResource(R.drawable.icon_bookmark),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(25.dp)
                    .zIndex(2f)
                    .clickable {
                        scope.launch { appConfigService.changeArticleFlag(article) }
                    }
            )

            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0x00FFFFFF),
                                Color(0x46000000),
                            )
                        )
                    )
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Icon(
                        contentDescription = null,
                        imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_back),
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { navigator.onBackButtonClick() }
                    )
                    Column {
                        Icon(
                            contentDescription = null,
                            imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Icon(
                            contentDescription = null,
                            imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_share),
                            tint = Color.White,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {
                                    requestedUrl.value = article.url
                                }
                        )
                    }
                }

                Column {
                    article.category?.let {
                        ArticleTag(tag = it.name.replaceFirstChar { c -> c.uppercaseChar() })
                        Spacer(Modifier.height(8.dp))
                    }
                    Text(
                        article.title,
                        color = Color.White,
                        style = NewsToDayType.NewDescFull
                    )
                    Spacer(modifier = Modifier.padding(12.dp))
                    Column {
                        Text(
                            article.author ?: "Noname",
                            color = Color.White,
                            style = NewsToDayType.SemiCommon
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            "Author",
                            color = PrimaryGrey,
                            style = NewsToDayType.SemiLight
                        )
                    }
                }
            }
        }

        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                article.description ?: "no desc",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                article.content ?: "no content",
                style = TextStyle(
                    color = Color(0xFF666C8E),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}