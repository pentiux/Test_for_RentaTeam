package ru.narod.pentiux.testforrentateam.repository.network

import io.reactivex.Observable
import retrofit2.http.GET

interface UserListApiService {
    @GET("/api/users")
    fun getUsers(): Observable<DataFromJson>
}