package com.example.pokemvvm.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.preference.Preference
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemvvm.R
import com.example.pokemvvm.data.model.Quote
import com.example.pokemvvm.ui.QuotesViewModel
import com.example.pokemvvm.ui.adapter.QuotesAdapter
import com.example.pokemvvm.util.InjectorUtils
import com.example.pokemvvm.util.SecurityUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var  lm: LinearLayoutManager
    private lateinit var  quotesRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)


        viewModel.getQuotes().observe(this, Observer { quotes ->
            lm = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
            quotesRecycler = quotesList
            quotesRecycler.layoutManager = lm
            quotesRecycler.adapter =
                QuotesAdapter(this, ArrayList(quotes))
                { clicked -> viewModel.removeQuote(clicked)}

            button_add_quote.setOnClickListener {
                val quote = Quote(quote_editText.text.toString())
                viewModel.addQuotes(quote)
                quote_editText.setText("")
            }
        })
    }
}
