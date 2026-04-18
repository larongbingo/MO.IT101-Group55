import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.motorph.AppRouter
import org.motorph.data.loading.loadData
import org.motorph.initKoin
import java.awt.Dimension

fun main() = application {
    initKoin()
    loadData()
    Window(onCloseRequest = ::exitApplication) {
        window.minimumSize = Dimension(600, 800)
        window.title = "MotorPh Payroll"
        MaterialTheme {
            AppRouter()
        }
    }
}