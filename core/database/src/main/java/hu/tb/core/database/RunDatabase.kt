package hu.tb.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.tb.core.database.dao.RunDao
import hu.tb.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
}