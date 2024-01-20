package org.company.app.data.datastore

import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.toSuspendSettings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class DataStore(
    val settings: Settings
) {

    val ridesCompletedFlow: MutableStateFlow<Int> = MutableStateFlow(
        settings.getInt(RIDES_KEY, 0)
    )

    suspend fun rideCompleted() {
        ridesCompletedFlow.update { it + 1 }
        settings[RIDES_KEY] = ridesCompletedFlow.value
    }

    suspend fun dropCompletedRides() {
        ridesCompletedFlow.update { 0 }
        settings[RIDES_KEY] = ridesCompletedFlow.value
    }

    companion object {
        const val RIDES_KEY = "RIDES_KEY"
    }
}