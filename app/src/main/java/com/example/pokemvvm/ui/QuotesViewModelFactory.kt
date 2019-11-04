package com.example.pokemvvm.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemvvm.data.dao.QuotesDatabaseDao

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory (
    private val dataSource: QuotesDatabaseDao,
    private val application: Application)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(dataSource,application) as T
    }
}