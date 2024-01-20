import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.company.app.App
import org.company.app.data.settings.Platform
import org.company.app.di.commonModule
import org.company.app.di.koin
import org.company.app.di.platformModule
import org.koin.core.context.startKoin
import java.awt.Dimension

fun main() = application {
    initKoin()

    Window(
        title = "Multiplatform App",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        App()
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