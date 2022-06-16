package com.training.ui.transformationage.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    //Livedata Privado é acessado no viewModel, publico é acessado na activity.

    //Estudar live data e mutable live data.

    private val _result: MutableLiveData<String> = MutableLiveData()
    val result: LiveData<String> = _result

    fun calculateAgeDog(age: Int, name: String){
        val transformAge = age * 7
        _result.value = "$transformAge $name"
    }

}