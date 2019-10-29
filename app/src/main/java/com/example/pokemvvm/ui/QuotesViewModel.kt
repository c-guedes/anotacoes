package com.example.pokemvvm.ui

import androidx.lifecycle.ViewModel
import com.example.pokemvvm.data.model.Quote
import com.example.pokemvvm.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel(){


    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}