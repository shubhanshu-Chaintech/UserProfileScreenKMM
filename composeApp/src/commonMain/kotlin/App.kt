import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.KoinContext
import org.koin.compose.rememberKoinInject
import ui.MainViewModel
import ui.ProfileScreen
import ui.ProfileScreenRoot

@Composable
fun App() {
    MaterialTheme {
//        val mainViewModel =
//            rememberKoinInject<MainViewModel>()
//        ProfileScreenRoot(mainViewModel)
        val mainViewModel:MainViewModel = MainViewModel()
        ProfileScreenRoot(
            viewModel = mainViewModel
        )
    }
}
