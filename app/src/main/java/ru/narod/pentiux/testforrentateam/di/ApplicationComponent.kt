package ru.narod.pentiux.testforrentateam.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.narod.pentiux.testforrentateam.MyApp
import ru.narod.pentiux.testforrentateam.repository.MyRepositoryImpl
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    RepositoryModule::class,
    FragmentBuilderModule::class,
    ActivityBuilderModule::class,
    PresenterModule::class])
interface ApplicationComponent : AndroidInjector<MyApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(myApp: MyApp): Builder

        fun build(): ApplicationComponent
    }

    fun repository(): MyRepositoryImpl

    override fun inject(app: MyApp)
}