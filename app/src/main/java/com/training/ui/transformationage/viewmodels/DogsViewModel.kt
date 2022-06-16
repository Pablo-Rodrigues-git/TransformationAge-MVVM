package com.training.ui.transformationage.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.ui.transformationage.data.Dog
import com.training.ui.transformationage.data.DogsManager

class DogsViewModel : ViewModel() {

    private val dogsManager = DogsManager()
    private val mDogs = MutableLiveData<List<Dog>>()

    fun getDogs(): MutableLiveData<List<Dog>> = mDogs

    fun loadDogs() {
        val tmp = dogsManager.getDog()
        mDogs.postValue(tmp)
    }
}