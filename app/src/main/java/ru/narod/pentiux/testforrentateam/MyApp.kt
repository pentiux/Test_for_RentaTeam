package ru.narod.pentiux.testforrentateam

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import ru.narod.pentiux.testforrentateam.di.ApplicationComponent
import ru.narod.pentiux.testforrentateam.di.DaggerApplicationComponent
import ru.narod.pentiux.testforrentateam.di.RepositoryModule


class MyApp : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .repositoryModule(RepositoryModule(this))
            .build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}