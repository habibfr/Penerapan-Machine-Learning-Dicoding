package com.dicoding.asclepius.data.di

import android.content.Context
import com.dicoding.asclepius.data.HistoryCancerRepository
import com.dicoding.asclepius.data.api.ApiConfig
import com.dicoding.asclepius.data.local.room.HistoryCancerDatabase
import com.dicoding.asclepius.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): HistoryCancerRepository {
        val apiService = ApiConfig.getApiService()
        val database = HistoryCancerDatabase.getInstance(context)
        val dao = database.historyCancerDao()
        val appExecutors = AppExecutors()
        return HistoryCancerRepository.getInstance(apiService, dao, appExecutors)
    }
}