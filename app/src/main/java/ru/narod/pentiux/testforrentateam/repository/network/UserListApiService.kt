package ru.narod.pentiux.testforrentateam.repository.network

import retrofit2.http.GET



interface UserListApiService {
    @GET("/api/users")
    suspend fun getUsers(): List<UserListApiService>
}