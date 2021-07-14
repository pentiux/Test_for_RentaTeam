package ru.narod.pentiux.testforrentateam.repository.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.narod.pentiux.testforrentateam.repository.model.entities.UserListEntity
import ru.narod.pentiux.testforrentateam.repository.model.dao.UserDao

@Database(
    entities = [UserListEntity::class],
    version = 1,
    exportSchema = false
    )
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao(): UserDao
}