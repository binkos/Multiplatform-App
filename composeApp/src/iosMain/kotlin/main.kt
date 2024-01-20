import androidx.compose.ui.window.ComposeUIViewController
import org.company.app.App
import org.company.app.data.settings.Platform
import org.company.app.di.commonModule
import org.company.app.di.koin
import org.company.app.di.platformModule
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }

fun InitKoin() {
    startKoin {
        val platformModule = platformModule(Platform())
        modules(platformModule, commonModule)
    }.also {
        koin = it.koin
    }

}