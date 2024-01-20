package org.company.app.data.repository

import kotlinx.coroutines.flow.Flow
import org.company.app.data.datastore.DataStore

class RidesRepository(
    private val dataStore: DataStore
) {

    fun observeCompletedRidesCount(): Flow<Int> = dataStore.ridesCompletedFlow

    suspend fun rideCompleted() {
        dataStore.rideCompleted()
    }

    suspend fun dropCompletedRides() {
        dataStore.dropCompletedRides()
    }
}