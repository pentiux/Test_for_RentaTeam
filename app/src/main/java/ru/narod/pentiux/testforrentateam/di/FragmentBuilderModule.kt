package ru.narod.pentiux.testforrentateam.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.narod.pentiux.testforrentateam.presenter.fragments.AboutMyApp
import ru.narod.pentiux.testforrentateam.presenter.fragments.UserCard
import ru.narod.pentiux.testforrentateam.presenter.fragments.UserList

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeUserList(): UserList

    @ContributesAndroidInjector
    abstract fun contributeUserCard(): UserCard

    @ContributesAndroidInjector
    abstract fun contributeAboutMyApp(): AboutMyApp
}