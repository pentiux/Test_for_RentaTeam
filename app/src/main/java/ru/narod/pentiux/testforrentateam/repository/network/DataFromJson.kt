package ru.narod.pentiux.testforrentateam.repository.network

import com.squareup.moshi.Json

data class DataFromJson(
    @field:Json(name = "page") val page: String?,
    @field:Json(name = "per_page") val per_page: String?,
    @field:Json(name = "total") val total: String?,
    @field:Json(name = "total_pages") val total_pages: String?,
    @field:Json(name = "data") val data: List<UserDataFromJson>,
    @field:Json(name = "support") val support: SupportInJson
)

@Json(name = "support")
data class SupportInJson (
    @field:Json(name = "url") val url: String,
    @field:Json(name = "text") val text: String
        )