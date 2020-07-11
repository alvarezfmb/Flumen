package com.alvarezfmb.flumen.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvarezfmb.flumen.domain.DataSource

@Database(entities = [DataSource::class], version = 1)
abstract class DataSourceDatabase : RoomDatabase() {

    abstract val dataSourceDao : DataSourceDao

    companion object {

        @Volatile
        private var INSTANCE: DataSourceDatabase? = null

        fun getInstance(context: Context): DataSourceDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataSourceDatabase::class.java,
                        "data_source_Database"
                    )
                        .fallbackToDestructiveMigration() // TODO https://codelabs.developers.google.com/codelabs/kotlin-android-training-room-database/#5
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}