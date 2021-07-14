package ru.narod.pentiux.testforrentateam

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex


class MyApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}