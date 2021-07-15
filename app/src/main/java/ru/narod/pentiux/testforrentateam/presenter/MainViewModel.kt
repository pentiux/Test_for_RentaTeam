package ru.narod.pentiux.testforrentateam.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.narod.pentiux.testforrentateam.presenter.data.*
import ru.narod.pentiux.testforrentateam.repository.MyRepository
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


class MainViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {

    var firstCall = true
    private val repoSubscription: Disposable = getDataFromRepository()

    private var _status = MutableLiveData<UserListStatus>(UserListLoading)
    val status: LiveData<UserListStatus> = _status

    private var _uiData = MutableLiveData<List<UserListData>>()
    val uiData: LiveData<List<UserListData>> = _uiData

    private fun getDataFromRepository() =
        repository.getUserData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { mapForPresenter(it) }
            .subscribe ({
                val error = repository.checkRetrofitErrors()
                if(error.isEmpty()) {
                    _uiData.value = it
                } else {
                    _status.value = UserListError(error)
                }
                        },
                        { _status.value = UserListError(it.message ?: "WTF?!") })


    private fun mapForPresenter(data: List<UserListEntity>): List<UserListData> {
        val tempList = mutableListOf<UserListData>()
        for (user in data) {
            tempList.add( UserListData(
                id = user.id,
                email = user.email,
                firstName = user.firstName,
                lastName = user.lastName,
                avatarUrl= user.avatarUrl
            ))
        }
        _status.value = UserListComplete
        return tempList
    }

    override fun onCleared() {
        super.onCleared()
        if (!repoSubscription.isDisposed) {
            repoSubscription.dispose()
        }
    }
}

@Singleton
class MainViewModelFactory @Inject constructor(
    private val creators: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}
