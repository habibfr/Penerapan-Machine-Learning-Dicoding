package com.dicoding.asclepius.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.dicoding.asclepius.data.api.ApiService
import com.dicoding.asclepius.data.local.entity.HistoryCancerEntity
import com.dicoding.asclepius.data.local.room.HistoryCancerDao
import com.dicoding.asclepius.utils.AppExecutors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class HistoryCancerRepository private constructor(
    private val apiService: ApiService,
    private val historyCancerDao: HistoryCancerDao,
    private val appExecutors: AppExecutors
) {
    private val result = MediatorLiveData<Result<List<HistoryCancerEntity>>>()

    fun getHistoryCancer(): LiveData<List<HistoryCancerEntity>> {
        return historyCancerDao.getHistoryCancer()
    }

    suspend fun insertHistoryCancer(historyCancer: HistoryCancerEntity) {
        appExecutors.diskIO.execute {
            historyCancerDao.insertHistoryCancer(historyCancer)
        }
    }

    suspend fun saveImageAnalysisResult(result: HistoryCancerEntity) {
        withContext(Dispatchers.IO) {
            historyCancerDao.insertHistoryCancer(result)
        }
    }


    companion object {
        @Volatile
        private var instance: HistoryCancerRepository? = null
        fun getInstance(
            apiService: ApiService,
            newsDao: HistoryCancerDao,
            appExecutors: AppExecutors
        ): HistoryCancerRepository =
            instance ?: synchronized(this) {
                instance ?: HistoryCancerRepository(apiService, newsDao, appExecutors)
            }.also { instance = it }
    }
}