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
) : Parcelable {
    companion object {
        fun getRandomData() = UserListData(
            id = (0..1000).random(),
            email = "sdfgkllk@dslkf.re".toList().shuffled().joinToString(""),
            firstName = "Fsdfdsv".toList().shuffled().joinToString(""),
            lastName = "asSDFSdfsdasgvncv".toList().shuffled().joinToString(""),
            avatarUrl = "asSDFSdfsdasgvncv".toList().shuffled().joinToString(""),
        )
    }
}
