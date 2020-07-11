package com.alvarezfmb.flumen.ui.suscriptions.addsuscription

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvarezfmb.flumen.database.DataSourceDao
import com.alvarezfmb.flumen.domain.DataSource
import kotlinx.coroutines.*


class AddSuscriptionViewModel(private val dataSourceDao: DataSourceDao) : ViewModel() {

    private val _validUrl = MutableLiveData<Boolean>()
    val validUrl : LiveData<Boolean> get() = _validUrl

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun validateUrl(input: String?) {
        _validUrl.value = !(input == null || !input.startsWith("http"))
    }

    fun onValidUrlAdded(url: String?) {
        url?.let {
            uiScope.launch {
                withContext(Dispatchers.IO) {
                    dataSourceDao.insert(DataSource(link = it))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}