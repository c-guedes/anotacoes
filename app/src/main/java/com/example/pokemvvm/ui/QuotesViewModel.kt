package com.example.pokemvvm.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pokemvvm.data.dao.QuotesDatabaseDao
import com.example.pokemvvm.data.model.Quote
import com.example.pokemvvm.data.repository.QuoteRepository
import kotlinx.coroutines.*

class QuotesViewModel(
    private val database: QuotesDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val repo = QuoteRepository.getInstance(database)
    private val viewModelJob = Job()
    private val quotes = repo.getQuotes()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()

        viewModelJob.cancel()
    }

    fun insertNewQuote(quote: Quote) {
        uiScope.launch {
            insert(quote)
        }
    }

    private suspend fun insert(quote: Quote) {
        withContext(Dispatchers.IO) {
            database.insert(quote)
        }
    }

    fun removeQuote(position: Long) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                //var aa = database.getAllQuotes()
                repo.removeQuote(position)
            }
        }
    }

    fun getQuotes() = repo.getQuotes()

    fun insertQuote(quote: Quote) = repo.addQuote(quote)

    fun addQuotes(quote: Quote) = repo.addQuote(quote)

}