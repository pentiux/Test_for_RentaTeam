package ru.narod.pentiux.testforrentateam.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Component
import ru.narod.pentiux.testforrentateam.MyApp
import ru.narod.pentiux.testforrentateam.repository.MyRepository
import ru.narod.pentiux.testforrentateam.repository.model.db.UserDatabase
import ru.narod.pentiux.testforrentateam.repository.network.UserListApiService
import javax.inject.Singleton


@Singleton
@Component(modules = [RepositoryModule::class])
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun provideMoshi(): Moshi

    fun provideUserListApiService(moshi: Moshi)

    fun providesUserDatabase(context: Context)

    fun repository(): MyRepository
}