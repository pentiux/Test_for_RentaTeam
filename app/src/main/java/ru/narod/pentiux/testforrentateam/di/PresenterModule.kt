package ru.narod.pentiux.testforrentateam.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.narod.pentiux.testforrentateam.presenter.MainViewModel
import ru.narod.pentiux.testforrentateam.presenter.MainViewModelFactory
import ru.narod.pentiux.testforrentateam.repository.MyRepository
import ru.narod.pentiux.testforrentateam.repository.MyRepositoryImpl
import javax.inject.Singleton

@Module
abstract class PresenterModule {

    @Singleton
    @Binds
    abstract fun repositoryInterface(repo: MyRepositoryImpl): MyRepository

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

}