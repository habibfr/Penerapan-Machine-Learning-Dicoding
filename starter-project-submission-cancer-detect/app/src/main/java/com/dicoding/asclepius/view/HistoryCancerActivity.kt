package com.dicoding.asclepius.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityHistoryCancerBinding

class HistoryCancerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryCancerBinding
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryCancerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)

        val mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]


        newsAdapter = NewsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvHistoryCancer.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvHistoryCancer.addItemDecoration(itemDecoration)


        mainViewModel.historyCancerList.observe(this) { noteList ->
            Log.d("HAS", noteList.size.toString())
//            println(noteList.)
            if (noteList != null) {
                val adapter = HistoryCancerAdapter(noteList);
                binding.rvHistoryCancer.adapter = adapter
            }
        }

    }
}