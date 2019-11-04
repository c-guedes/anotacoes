package com.example.pokemvvm.data.repository

import com.example.pokemvvm.data.dao.QuotesDatabaseDao
import com.example.pokemvvm.data.model.Quote

class QuoteRepository private constructor(private val quoteDatabaseDao: QuotesDatabaseDao) {

    fun addQuote(quote: Quote) {
        quoteDatabaseDao.insert(quote)
    }

    fun removeQuote(position: Long) {
        quoteDatabaseDao.removeSelected(position)
    }

    fun getQuotes() = quoteDatabaseDao.getAllQuotes()

    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(quoteDatabaseDao: QuotesDatabaseDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDatabaseDao).also { instance = it }
            }
    }

}