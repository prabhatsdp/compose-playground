package dev.prabhatpandey.composeplayground.features.calendar.ui

/**
 * CalendarViewModel
 *
 * Created by Prabhat Pandey on 02/08/2024
 * for ComposePlayground
 */
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prabhatpandey.composeplayground.core.di.DispatcherProvider
import dev.prabhatpandey.logex.log.logDebug
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    init {
        viewModelScope.launch {
            val a = async {
                "Prabhat"
            }
            val b = async {
                3
            }
            val c = async {
                false
            }

            val d = async {
                LocalDate.now()
            }
            val results = awaitAll(a, b, c, d)

            val aResult = results.first()
            val bResult = results[1]
            val cResult = results[2]
            val dResult = results[3]

            logDebug("A => $aResult")
            logDebug("B => $bResult")
            logDebug("C => $cResult")
            logDebug("D => $dResult")
            Log.d("CalendarViewModel", "Message")
        }
    }

    fun log() {
        logDebug("ViewModel initialized"    )
    }
}
