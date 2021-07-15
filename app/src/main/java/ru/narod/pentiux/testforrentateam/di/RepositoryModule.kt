package ru.narod.pentiux.testforrentateam.di

import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.narod.pentiux.testforrentateam.MyApp
import ru.narod.pentiux.testforrentateam.repository.model.db.UserDatabase
import ru.narod.pentiux.testforrentateam.repository.network.UserListApiService
import javax.inject.Singleton


private const val BASE_URL = "https://reqres.in"

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideUserListApiService(moshi: Moshi): UserListApiService =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UserListApiService::class.java)

    @Singleton
    @Provides
    fun providesUserDatabase(myApp: MyApp): UserDatabase =
        Room.databaseBuilder(
            myApp,
            UserDatabase::class.java,
            "user_list_bd_1"
        ).fallbackToDestructiveMigration().build()
}