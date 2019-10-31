package com.example.pokemvvm.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.pokemvvm.util.Constants.PREF_NAME


@Suppress("UNCHECKED_CAST")
class SharedPrefsManager(context: Context) {

    var prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, 0)

    companion object{
        @Volatile private var instance: SharedPrefsManager? = null

        fun getInstance(context: Context)=
            instance ?: synchronized(this){
                instance ?: SharedPrefsManager(context).also{ instance = it}
            }
    }


}