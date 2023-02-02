package com.example.counter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.counter.adapter.CounterAdapter
import com.example.counter.databinding.FragmentCounterBinding
import com.example.counter.viewModel.CounterViewModel


class CounterFragment : Fragment() {

    private lateinit var viewModel: CounterViewModel
    private lateinit var adapter: CounterAdapter
    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        adapter = CounterAdapter(this::onMinusClick, this::onPlusClick)
        binding.counterPager.adapter = adapter
        observers()
    }

    private fun observers() {
        viewModel.mCounter.observe(viewLifecycleOwner) {
            adapter.getResult(it)
        }
        viewModel.history.observe(viewLifecycleOwner) {
            adapter.getHistory(it)
        }
    }

    private fun onMinusClick() {
        viewModel.oDecrementClick()
    }

    private fun onPlusClick() {
        viewModel.onIncrementClick()
    }

}
