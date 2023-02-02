package com.example.counter.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel(){

    private var count = 0
    private val listHistory:ArrayList<String> = arrayListOf()
    val mCounter = MutableLiveData<Int>()
    val history = MutableLiveData<ArrayList<String>>()

    fun onIncrementClick(){
        count++
        mCounter.value = count
        listHistory.add("+")
        history.value = listHistory
    }

    fun oDecrementClick(){
        count--
        mCounter.value = count
        listHistory.add("-")
        history.value = listHistory
    }

}
