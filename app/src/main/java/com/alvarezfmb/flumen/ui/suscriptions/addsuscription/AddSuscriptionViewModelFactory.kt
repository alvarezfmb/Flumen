package com.alvarezfmb.flumen.ui.suscriptions.addsuscription

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alvarezfmb.flumen.database.DataSourceDao


class AddSuscriptionViewModelFactory(private val dataSourceDao: DataSourceDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddSuscriptionViewModel::class.java)) {
            return AddSuscriptionViewModel(dataSourceDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}