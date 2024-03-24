package com.dicoding.asclepius.view

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.asclepius.R
import com.dicoding.asclepius.Result
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
        val hasil = intent.getStringExtra(HASIL)
        val imageUri = intent.getParcelableExtra<Uri>(IMAGE)

        displayResults(hasil, imageUri)
    }

    @SuppressLint("SetTextI18n")
    private fun displayResults(hasil: String?, img: Uri?) {
        binding.resultImage.setImageURI(img)
        binding.resultText.text = "Hasilnya adalah $hasil"

    }

    companion object {
        const val HASIL = "hasil"
        const val IMAGE = "image"
    }
}