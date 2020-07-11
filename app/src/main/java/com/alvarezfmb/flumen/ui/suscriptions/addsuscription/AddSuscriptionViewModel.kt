package com.alvarezfmb.flumen.ui.suscriptions.addsuscription

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvarezfmb.flumen.database.DataSourceDao
import com.alvarezfmb.flumen.domain.DataSource


class AddSuscriptionViewModel(private val dataSourceDao: DataSourceDao) : ViewModel() {

    private val _validUrl = MutableLiveData<Boolean>()
    val validUrl : LiveData<Boolean> get() = _validUrl

    fun validateUrl(input: String?) {
        _validUrl.value = !(input == null || !input.startsWith("http"))
    }

    fun onValidUrlAdded(url: String?) {
        url?.let {
            dataSourceDao.insert(DataSource(link = it))
        }
    }
}