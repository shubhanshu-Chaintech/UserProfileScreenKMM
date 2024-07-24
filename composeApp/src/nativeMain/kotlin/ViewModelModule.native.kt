import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.MainViewModel

actual val ViewModelModule = module {
    singleOf(::MainViewModel)
}