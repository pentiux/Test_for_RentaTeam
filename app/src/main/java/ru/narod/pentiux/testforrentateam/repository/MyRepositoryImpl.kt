package ru.narod.pentiux.testforrentateam.repository


import io.reactivex.schedulers.Schedulers
import ru.narod.pentiux.testforrentateam.repository.model.db.UserDatabase
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity
import ru.narod.pentiux.testforrentateam.repository.network.UserDataFromJson
import ru.narod.pentiux.testforrentateam.repository.network.UserListApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepositoryImpl @Inject constructor(
    userDatabase: UserDatabase,
    private val userListApi: UserListApiService
) : MyRepository {

    private val userDao = userDatabase.getDao()
    private val userListFromNetwork = mutableListOf<UserListEntity>()
    private var retrofitError = ""

    init {
        getDataFromNetwork()
    }

    override fun checkRetrofitErrors(): String = retrofitError

    override fun getUserData() = userDao.getAllUserData()

    override fun deleteAllUserData() = userDao.clearTable()

    private fun getDataFromNetwork() = userListApi.getUsers()
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .subscribe({
            converterForDb(it.data)
            userDao.insertAllData(userListFromNetwork)
            },
            { retrofitError = it.message ?: "" }
        )

    private fun converterForDb(data: List<UserDataFromJson>) {
        for (user in data) {
            userListFromNetwork.add(UserListEntity(
                id = user.id,
                email = user.email,
                firstName = user.first_name,
                lastName = user.last_name,
                avatarUrl = user.avatar
                )
            )
        }
    }
}