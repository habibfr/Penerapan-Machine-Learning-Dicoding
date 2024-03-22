package com.habibfr.latihantensorflowliteprediction

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.habibfr.latihantensorflowliteprediction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var predictionHelper: PredictionHelper

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        predictionHelper = PredictionHelper(
            context = this,
            onResult = { result ->
                binding.tvResult.text = "$result Kg"
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()

            },
            onError = { errorMessage ->
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
        binding.btnPredict.setOnClickListener {
            val input = binding.edSales.text.toString()
            predictionHelper.predict(input)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        predictionHelper.close()
    }

}