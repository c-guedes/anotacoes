package com.example.pokemvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokemvvm.data.model.Quote

@Dao
interface QuotesDatabaseDao {

    @Insert
    fun insert(quote: Quote)

    @Query("DELETE FROM `quotes_database_table`")
    fun clear()

    @Query("SELECT * FROM `quotes_database_table` ORDER BY quoteId DESC")
    fun getAllQuotes() : LiveData<List<Quote>>

    @Update
    fun update(quote: Quote)

//    @Query("SELECT * FROM `quotes_database_table ` WHERE quoteId = :key")
//    fun getQuote(key: Long)

    @Query("DELETE FROM `quotes_database_table` WHERE quoteId = :key")
    fun removeSelected(key: Long)
}