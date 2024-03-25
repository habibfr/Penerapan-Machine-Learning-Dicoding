package com.dicoding.asclepius.view

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.R
import com.dicoding.asclepius.Result
import com.dicoding.asclepius.data.api.ArticlesItem
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var newsAdapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        val mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        newsAdapter = NewsAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvNews.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvNews.addItemDecoration(itemDecoration)

        mainViewModel.news.observe(this) { news ->
            setNewsData(news)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val news = intent.getBooleanExtra(NEWS, false)

        if(news){
            binding.resultImage.visibility = View.GONE
            binding.resultText.visibility = View.GONE
        }else{
            binding.resultImage.visibility = View.VISIBLE
            binding.resultText.visibility = View.VISIBLE
            val hasil = intent.getStringExtra(HASIL)
            val imageUri = intent.getParcelableExtra<Uri>(IMAGE)
            displayResults(hasil, imageUri)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun displayResults(hasil: String?, img: Uri?) {
        binding.resultImage.setImageURI(img)
        binding.resultText.text = Html.fromHtml("Hasilnya <b>$hasil</b> <br/><p><small>Berikut artikel yang bermanfaat untuk anda :</small></p>", Html.FROM_HTML_MODE_COMPACT)
    }

    private fun setNewsData(news: List<ArticlesItem>) {
        newsAdapter.submitList(news)
        Log.d("WHAT", "hello ${news.size}")
        binding.rvNews.adapter = newsAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val HASIL = "hasil"
        const val IMAGE = "image"
        const val NEWS = "news"
    }
}