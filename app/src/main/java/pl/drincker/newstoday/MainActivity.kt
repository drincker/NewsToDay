package pl.drincker.newstoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import pl.drincker.newstoday.ui.theme.NewsToDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsToDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val appConfigDataStore: AppConfigService = koinInject()
//
//                    LaunchedEffect(null) {
//                        var config = appConfigDataStore.getAppConfig()
//                        Log.d("m", "config: $config")
//
//                        appConfigDataStore.updateAppConfig(
//                            language = Language.EN
//                        )
//                        delay(1000)
//                        config = appConfigDataStore.getAppConfig()
//                        Log.d("m", "updated config: $config")
//                    }
                }
            }
        }
    }
}