package ru.narod.pentiux.testforrentateam.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.narod.pentiux.testforrentateam.presenter.MainActivity

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}