import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.company.app.App
import org.company.app.data.settings.Platform
import org.company.app.di.commonModule
import org.company.app.di.koin
import org.company.app.di.platformModule
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    onWasmReady {
        CanvasBasedWindow("Multiplatform App") {
            App()
        }
    }
}

fun initKoin() {
    startKoin {
        val platformModule = platformModule(Platform())
        modules(platformModule, commonModule)
    }.also {
        koin = it.koin
    }
}