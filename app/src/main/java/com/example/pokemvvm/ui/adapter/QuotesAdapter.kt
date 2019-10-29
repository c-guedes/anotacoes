package com.example.pokemvvm.ui.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pokemvvm.R
import com.example.pokemvvm.data.model.Quote
import kotlinx.android.synthetic.main.base_recycler.view.*


class QuotesAdapter(
    private val context: Context, private val quot: List<Quote>
) : Adapter<QuotesAdapter.ViewHolder>() {
    private val list: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.base_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quot.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.quote.text = quot[position].quoteText
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init vals
        val quote = itemView.quoteText
    }

//    private fun getImage(brandName: String): Int {
//        return when (brandName) {
//            "VISA" -> R.drawable.ic_visa
//            "ELO CREDITO" -> R.drawable.ic_elo
//            "MAESTRO" -> R.drawable.ic_maestro
//            "DISCOVER" -> R.drawable.ic_discover
//            "MASTER" -> R.drawable.ic_master
//            else -> R.drawable.ic_visa
//        }
//    }
//
//    private fun concatenateStrings(campo: String, numParcel: Int): String{
//        return when (campo){
//            "Parcelamento sem Juros" -> "Parcelamento S/ Juros (${numParcel}x)"
//            "Parcelamento com Juros" -> "Parcelamento C/ Juros (${numParcel}x)"
//            else -> campo
//        }
//
//    }
//
//    private fun getStatus(estado: Int): String{
//        return when(estado){
//            0 -> "Pendente | "
//            1 -> "Confirmada | "
//            2 -> "Desfeita | "
//            3 -> "Negada | "
//            else -> "Cancelada | "
//        }
//    }
}