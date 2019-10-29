package com.example.pokemvvm.util

import com.example.pokemvvm.data.model.FakeDatabase
import com.example.pokemvvm.data.repository.QuoteRepository
import com.example.pokemvvm.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository= QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}