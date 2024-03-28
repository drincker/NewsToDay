package pl.drincker.newstoday

import android.app.Application
import com.whatrushka.di.appConfigModule
import com.whatrushka.di.newsApiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NewsToDayApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsToDayApp)
            androidLogger(Level.DEBUG)
            modules(
                appConfigModule,
                newsApiModule,
            )
        }
    }
}