package com.example.pokemvvm.data.repository

import com.example.pokemvvm.data.model.FakeQuoteDao
import com.example.pokemvvm.data.model.Quote

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun removeQuote(position: Int){
        quoteDao.removeQuote(position)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao)=
            instance ?: synchronized(this){
                instance ?: QuoteRepository(quoteDao).also{ instance = it}
            }
    }

}