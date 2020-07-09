package com.alvarezfmb.flumen.ui.suscriptions.addsuscription

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AddSuscriptionViewModel : ViewModel() {

    private val _validUrl = MutableLiveData<Boolean>()
    val validUrl : LiveData<Boolean> get() = _validUrl

    fun validateUrl(input: String?) {
        _validUrl.value = !(input == null || !input.startsWith("http"))
    }
}