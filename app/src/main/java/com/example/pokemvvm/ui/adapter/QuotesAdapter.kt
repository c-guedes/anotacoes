package com.example.pokemvvm.ui.adapter


import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pokemvvm.R
import com.example.pokemvvm.data.model.Quote
import kotlinx.android.synthetic.main.base_recycler.view.*






class QuotesAdapter(
    private val context: Context, private val quot: ArrayList<Quote>,
    val clickListener:(positionNow: Int )-> Unit
) : Adapter<QuotesAdapter.ViewHolder>() {
    val sQuot = mutableListOf(quot)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.base_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quot.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mQuoq: Quote = quot[position]

        holder.mQuote.text = mQuoq.quoteText

        holder.bind(mQuoq,context.resources)

        holder.mHeader.setOnClickListener {
            // Get the current state of the item
            val mExpanded = mQuoq.expanded
            // Change the state
            mQuoq.expanded = !mExpanded
            // Notify the adapter that item has changed
            notifyItemChanged(position)
        }


        holder.mClose.setOnClickListener{
            quot.removeAt(position)
            clickListener(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, quot.size)
            Log.e("WHO",quot.toString())
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init vals
        val mQuote = itemView.quoteText
        val mHeader = itemView.lmexpand
        val mClose = itemView.ic_close

        fun bind(quoq: Quote, res: Resources){
            val expanded = quoq.expanded
            mQuote.visibility =
                if(expanded){
                    mHeader.background = res.getDrawable(R.drawable.top_baloon_cornered, null)
                    GONE
                }else{
                    mHeader.background = res.getDrawable(R.drawable.top_baloon, null)
                    VISIBLE
                }
        }
    }
}