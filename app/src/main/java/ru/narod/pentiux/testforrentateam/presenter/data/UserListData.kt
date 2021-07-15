package ru.narod.pentiux.testforrentateam.presenter.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserListData(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String
) : Parcelable