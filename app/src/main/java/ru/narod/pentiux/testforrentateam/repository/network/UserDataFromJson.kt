package ru.narod.pentiux.testforrentateam.repository.network

import com.squareup.moshi.Json

@Json(name = "data")
data class UserDataFromJson(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String,
    @field:Json(name = "avatar") val avatarUrl: String
)
