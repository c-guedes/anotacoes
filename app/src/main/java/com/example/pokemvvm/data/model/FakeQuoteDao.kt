package com.example.pokemvvm.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = ArrayList<Quote>()
    private val quotes = MutableLiveData<ArrayList<Quote>>()

    init{
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<ArrayList<Quote>>

    fun removeQuote(position: Int) = quoteList.removeAt(position)
}