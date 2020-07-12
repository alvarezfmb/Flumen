package com.alvarezfmb.flumen.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alvarezfmb.flumen.domain.DataSource

@Dao
interface DataSourceDao {

    @Insert
    fun insert(dataSource: DataSource)

    @Query("SELECT * from data_source_table")
    fun getAll() : LiveData<List<DataSource>>
}