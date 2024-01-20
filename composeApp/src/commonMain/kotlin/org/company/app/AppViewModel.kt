package org.company.app

import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.company.app.data.repository.RidesRepository

class AppViewModel(
    private val ridesRepository: RidesRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            ridesRepository.observeCompletedRidesCount()
                .onEach { ridesToBreakEvenPointStateFlow.value = it }
                .collect()
        }
    }

    val ridesToBreakEvenPointStateFlow = MutableStateFlow(0).cMutableStateFlow()

    fun onRideCompleted() {
        viewModelScope.launch {
            ridesRepository.rideCompleted()
        }
    }

    fun dropCompletedRides() {
        viewModelScope.launch {
            ridesRepository.dropCompletedRides()
        }
    }
}