package ru.narod.pentiux.testforrentateam.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity

interface MyRepository {

    fun getUserData(): Flowable<List<UserListEntity>>

    fun deleteAllUserData(): Completable

    fun checkRetrofitErrors(): String
}