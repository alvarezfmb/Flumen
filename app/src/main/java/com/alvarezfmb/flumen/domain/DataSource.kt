package com.alvarezfmb.flumen.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_source_table")
data class DataSource(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                      val link: String)