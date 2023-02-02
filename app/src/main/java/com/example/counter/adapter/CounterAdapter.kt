package com.example.counter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.counter.databinding.ItemCounterPagerBinding

class CounterAdapter(
    val onMinusClick: () -> Unit,
    val onPlusClick: () -> Unit
) :
    RecyclerView.Adapter<CounterAdapter.CounterViewHolder>() {
    private var resultNum = 0
    private val adapter = HistoryAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterViewHolder {
        return CounterViewHolder(
            ItemCounterPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: CounterViewHolder, position: Int) {
        holder.bind(resultNum)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getResult(result: Int) {
        resultNum = result
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getHistory(history: ArrayList<String>) {
        adapter.getHistory(history)
        notifyDataSetChanged()
    }

    inner class CounterViewHolder(private val binding: ItemCounterPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Int) {
            initRecycler()
            binding.recyclerCount.isVisible = adapterPosition == 2
            binding.btnMinus.isVisible = adapterPosition == 0
            binding.btnPlus.isVisible = adapterPosition == 0
            binding.textResult.isVisible = adapterPosition == 1

            binding.btnMinus.setOnClickListener {
                onMinusClick()
            }
            binding.btnPlus.setOnClickListener {
                onPlusClick()
            }
            binding.textResult.text = result.toString()
        }

        private fun initRecycler() {
            binding.apply {
                recyclerCount.layoutManager = LinearLayoutManager(itemView.context)
                recyclerCount.adapter = adapter
            }
        }
    }

}