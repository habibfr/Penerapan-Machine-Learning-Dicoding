package com.dicoding.asclepius.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.HistoryCancerRepository
import com.dicoding.asclepius.data.api.ApiConfig
import com.dicoding.asclepius.data.api.ApiService
import com.dicoding.asclepius.data.api.ArticlesItem
import com.dicoding.asclepius.data.api.NewsResponse
import com.dicoding.asclepius.data.local.entity.HistoryCancerEntity
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val historyCancerRepository: HistoryCancerRepository) : ViewModel() {
    private val _news = MutableLiveData<List<ArticlesItem>>()
    val news: LiveData<List<ArticlesItem>> = _news

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getNews()
    }

    private fun getNews() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getNews()
        client.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
//                    Log.d("HASIL", response.body().toString())
                    _news.value = response.body()?.articles
//                    _listReview.value = response.body()?.restaurant?.customerReviews
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    val historyCancerList: LiveData<List<HistoryCancerEntity>> =
        historyCancerRepository.getHistoryCancer()

    fun insertHistoryCancer(historyCancer: HistoryCancerEntity) {
        viewModelScope.launch {
            historyCancerRepository.insertHistoryCancer(historyCancer)
        }
    }

    companion object{
        private const val TAG = "MainViewModel"
    }
}