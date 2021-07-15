package ru.narod.pentiux.testforrentateam

import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.narod.pentiux.testforrentateam.di.DaggerApplicationComponent


class MyApp : DaggerApplication() {

    private val injector = DaggerApplicationComponent.builder().application(this).build()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = injector

}