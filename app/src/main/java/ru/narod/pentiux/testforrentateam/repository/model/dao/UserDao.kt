package ru.narod.pentiux.testforrentateam.repository.model.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_list")
    fun getAllHabits(): Flowable<List<UserListEntity>>
}