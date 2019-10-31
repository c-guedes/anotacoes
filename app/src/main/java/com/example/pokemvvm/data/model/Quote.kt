package com.example.pokemvvm.data.model

data class Quote(val quoteText: String, var expanded: Boolean = true){
    override fun toString(): String{
        return quoteText
    }
}