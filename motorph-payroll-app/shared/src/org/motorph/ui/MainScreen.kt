package org.motorph.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import org.motorph.employees.Employee
import org.motorph.ui.mainscreen.NextPayrollCard
import org.motorph.ui.mainscreen.PayrollBarGraph
import java.time.LocalDate

@Composable
fun MainScreen() {
    Column(Modifier.padding(8.dp)) {
        NextPayrollCard(LocalDate.now().plusDays(20))

        PayrollBarGraph()
    }
}

data class MainUiState(
    val employee: Employee,
    val isLoading: Boolean = false,
)

class MainViewModel() : ViewModel() {

}