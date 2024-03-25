package com.dicoding.asclepius.view

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.R
import com.dicoding.asclepius.data.local.entity.HistoryCancerEntity
import com.dicoding.asclepius.databinding.ItemHistoryCancerBinding
import com.dicoding.asclepius.databinding.NewsItemBinding
import java.text.NumberFormat

class HistoryCancerAdapter(private val historyList: List<HistoryCancerEntity>) :
    RecyclerView.Adapter<HistoryCancerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHistoryCancerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyItem = historyList[position]
        holder.bind(historyItem)
    }

    override fun getItemCount(): Int = historyList.size

    inner class ViewHolder(private val binding: ItemHistoryCancerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historyItem: HistoryCancerEntity) {
            itemView.apply {
                // Tampilkan data historyItem dalam tampilan item
                binding.imgPosterHistory.setImageURI(Uri.parse(historyItem.imagePath))
                println(historyItem.imagePath)
                binding.tvItemTitleHistory.text = historyItem.label
                binding.tvItemPublishedDateHistort.text = NumberFormat.getPercentInstance().format(historyItem.score).trim()
                binding.tvItemDate.text = historyItem.date
            }
        }
    }
}