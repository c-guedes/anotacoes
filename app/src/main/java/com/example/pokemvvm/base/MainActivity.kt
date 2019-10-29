package com.example.pokemvvm.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokemvvm.R
import com.example.pokemvvm.data.model.Quote
import com.example.pokemvvm.ui.QuotesViewModel
import com.example.pokemvvm.util.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

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
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
            button_add_quote.setOnClickListener {
                val quote = Quote(quote_editText.text.toString(), author_editText.text.toString())
                viewModel.addQuotes(quote)
                quote_editText.setText("")
                author_editText.setText("")
            }
        })

    }
}
