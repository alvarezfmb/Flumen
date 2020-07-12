package com.alvarezfmb.flumen.ui.suscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alvarezfmb.flumen.database.DataSourceDao


class SuscriptionsViewModelFactory(private val dataSourceDao: DataSourceDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SuscriptionsViewModel::class.java)) {
            return SuscriptionsViewModel(dataSourceDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}