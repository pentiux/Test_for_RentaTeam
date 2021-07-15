package ru.narod.pentiux.testforrentateam.presenter.data

sealed class UserListStatus
class UserListError(val message: String) : UserListStatus()
object UserListComplete : UserListStatus()
object UserListLoading : UserListStatus()

