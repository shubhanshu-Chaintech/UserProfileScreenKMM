import org.koin.dsl.module
import ui.MainViewModel

val appModule = module{
 single { MainViewModel() }
}