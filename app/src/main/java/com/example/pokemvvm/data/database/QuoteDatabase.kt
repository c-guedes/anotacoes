/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.pokemvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokemvvm.data.dao.QuotesDatabaseDao
import com.example.pokemvvm.data.model.Quote


@Database(entities = [Quote::class], version = 1, exportSchema = false)
abstract class QuoteDatabase() : RoomDatabase(){
    abstract val quoteDatabaseDao: QuotesDatabaseDao

    companion object{
        @Volatile var INSTANCE: QuoteDatabase? = null
        fun getInstance(context: Context): QuoteDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            QuoteDatabase::class.java,
                            "quotes_database_table"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}