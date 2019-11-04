package com.example.pokemvvm.util

import android.app.Application
import com.example.pokemvvm.data.database.QuoteDatabase
import com.example.pokemvvm.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(application: Application): QuotesViewModelFactory {
        val dataSource = QuoteDatabase.getInstance(application).quoteDatabaseDao
        return QuotesViewModelFactory(dataSource, application)
    }
}