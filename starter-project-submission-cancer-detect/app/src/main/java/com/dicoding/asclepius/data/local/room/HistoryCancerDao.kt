package com.dicoding.asclepius.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.asclepius.data.local.entity.HistoryCancerEntity

@Dao
interface HistoryCancerDao {
    @Query("SELECT * FROM history_cancer ORDER BY date DESC")
    fun getHistoryCancer(): LiveData<List<HistoryCancerEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHistoryCancer(historyCancer: HistoryCancerEntity)

    @Update
    fun updateHistoryCancer(historyCancer: HistoryCancerEntity)

    @Delete
    fun delete(historyCancer: HistoryCancerEntity)

    @Query("SELECT * from history_cancer ORDER BY id ASC")
    fun getAllHistory(): LiveData<List<HistoryCancerEntity>>

}
//
//    @Query("DELETE FROM news WHERE bookmarked = 0")
//    fun deleteAll()
//
//    @Query("SELECT EXISTS(SELECT * FROM news WHERE title = :title AND bookmarked = 1)")
//    fun isNewsBookmarked(title: String): Boolean
//}