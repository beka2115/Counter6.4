package com.example.counter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.counter.databinding.ItemCountBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val listHistory: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemCountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(listHistory[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getHistory(history: ArrayList<String>){
        listHistory.clear()
        listHistory.addAll(history)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemCountBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyList:String) {
           binding.textHistory.text = historyList
        }
    }

}