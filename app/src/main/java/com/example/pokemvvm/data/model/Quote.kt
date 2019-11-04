package com.example.pokemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quotes_database_table")
data class Quote(
    @ColumnInfo(name = "quote_text")
    val quoteText: String,

    @ColumnInfo(name = "expanded")
    var expanded: Boolean = true
) {
    @PrimaryKey(autoGenerate = true)
    var quoteId: Long = 0L

    override fun toString(): String {
        return quoteText
    }
}