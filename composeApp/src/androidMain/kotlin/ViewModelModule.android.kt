import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ui.MainViewModel

actual val ViewModelModule = module {
    viewModelOf(::MainViewModel)
}
