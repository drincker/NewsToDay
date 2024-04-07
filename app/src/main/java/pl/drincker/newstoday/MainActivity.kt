package pl.drincker.newstoday

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.whatrushka.api.appconfig.AppConfigService
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import pl.drincker.newstoday.navigation.MainNavigationScreen
import pl.drincker.newstoday.ui.theme.NewsToDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val content: View = findViewById(android.R.id.content)
            val scope = rememberCoroutineScope()
            val appConfigService: AppConfigService = koinInject()
            val isWelcome = remember { mutableStateOf<Boolean?>(null) }

            LaunchedEffect(key1 = null) {
                content.viewTreeObserver.addOnPreDrawListener(
                    object : ViewTreeObserver.OnPreDrawListener {
                        override fun onPreDraw(): Boolean {
                            scope.launch {
                                isWelcome.value = appConfigService.isWelcome()
                            }
                            return if (isWelcome.value != null && isWelcome.value!!) {
                                content.viewTreeObserver.removeOnPreDrawListener(this)
                                isWelcome.value = true
                                true
                            } else {
                                content.viewTreeObserver.removeOnPreDrawListener(this)
                                isWelcome.value = false
                                false
                            }
                        }
                    },
                )
            }

            val navController = rememberNavController()

            NewsToDayTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    color = Color.White,
                ) {
                    isWelcome.value?.let {
                        MainNavigationScreen(
                            it,
                            navController = navController,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .background(Color.White)
                        )
                    }
                }
            }
        }
    }
}