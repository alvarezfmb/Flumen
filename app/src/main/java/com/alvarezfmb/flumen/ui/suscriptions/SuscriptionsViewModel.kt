package com.alvarezfmb.flumen.ui.suscriptions

import androidx.lifecycle.ViewModel
import com.alvarezfmb.flumen.database.DataSourceDao


class SuscriptionsViewModel(dataSourceDao: DataSourceDao) : ViewModel() {

    val suscriptions = dataSourceDao.getAll()
}