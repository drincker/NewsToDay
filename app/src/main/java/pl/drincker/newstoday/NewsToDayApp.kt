package pl.drincker.newstoday

import android.app.Application
import com.example.di.onboardingModule
import com.whatrushka.bookmarks.di.bookmarksModule
import com.whatrushka.di.articleModule
import com.whatrushka.di.dataModule
import com.whatrushka.di.homeModule
import com.whatrushka.di.newsApiModule
import com.whatrushka.features.profile.di.profileModule
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
                dataModule,
                newsApiModule,
                homeModule,
                articleModule,
                profileModule,
                onboardingModule,
                bookmarksModule
            )
        }
    }
}