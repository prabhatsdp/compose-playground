package dev.prabhatpandey.composeplayground.features.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prabhatpandey.composeplayground.features.clock.models.ClockTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ClockViewModel @Inject constructor() : ViewModel() {


    private val _clockTime = MutableStateFlow(currentClockTime())
    val clockTime = _clockTime.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                _clockTime.update {
                    currentClockTime()
                }
                delay(16)
            }
        }
    }

    private fun currentClockTime() : ClockTime {
        return  LocalDateTime.now().let { ClockTime(it.hour, it.minute, it.second) }
    }
}


