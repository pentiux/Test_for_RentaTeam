package ru.narod.pentiux.testforrentateam.repository.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import ru.narod.pentiux.testforrentateam.repository.entities.UserListEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_list")
    fun getAllHabits(): Flowable<List<UserListEntity>>
}