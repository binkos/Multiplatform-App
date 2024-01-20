package org.company.app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.company.app.di.koin
import org.company.app.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun App() = AppTheme {
    val viewModel: AppViewModel = getViewModel(
        key = "AppViewModel",
        factory = viewModelFactory {
            AppViewModel(ridesRepository = koin.get())
        }
    )
    val completedRidesCount by viewModel.ridesToBreakEvenPointStateFlow.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.weight(0.1f))

        Text("Количество совершённых поездок на метро:")
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = completedRidesCount.toString(),
        )

        Spacer(Modifier.weight(0.7f))

        Text(
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .combinedClickable(
                    onClick = { viewModel.onRideCompleted() },
                    onLongClick = { viewModel.dropCompletedRides() },
                    enabled = true,
                )
                .background(color = MaterialTheme.colorScheme.onPrimary, CircleShape)
                .wrapContentSize(),
            text = "Яхай Баля",
        )

        Spacer(Modifier.weight(0.2f))
    }
}

internal expect fun openUrl(url: String?)