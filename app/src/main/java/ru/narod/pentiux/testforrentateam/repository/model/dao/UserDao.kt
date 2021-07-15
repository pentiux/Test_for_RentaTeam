package ru.narod.pentiux.testforrentateam.repository.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(data: List<UserListEntity>)

    @Query("SELECT * FROM user_list")
    fun getAllUserData(): Flowable<List<UserListEntity>>

    @Query("DELETE FROM user_list")
    fun clearTable(): Completable
}