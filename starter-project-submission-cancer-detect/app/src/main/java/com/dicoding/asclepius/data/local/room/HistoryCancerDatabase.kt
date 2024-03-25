package com.dicoding.asclepius.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.asclepius.data.local.entity.HistoryCancerEntity


@Database(entities = [HistoryCancerEntity::class], version = 1, exportSchema = false)
abstract class HistoryCancerDatabase : RoomDatabase() {
    abstract fun historyCancerDao(): HistoryCancerDao

    companion object {
        @Volatile
        private var instance: HistoryCancerDatabase? = null
        fun getInstance(context: Context): HistoryCancerDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    HistoryCancerDatabase::class.java, "history_cancer.db"
                ).build()
            }
    }
}