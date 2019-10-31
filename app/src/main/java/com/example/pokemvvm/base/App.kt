package com.example.pokemvvm.base

import android.app.Application
import com.example.pokemvvm.util.PreferenceHelper
import com.example.pokemvvm.util.SharedPrefsManager

val prefs: SharedPrefsManager by lazy {
    App.prefs!!
}

val teste: PreferenceHelper by lazy {
    App.teste!!
}


class App: Application() {
    companion object {
        var prefs: SharedPrefsManager? = null
        var teste: PreferenceHelper? = null
    }

    override fun onCreate() {
        prefs = SharedPrefsManager(applicationContext)
        teste = PreferenceHelper
        super.onCreate()
    }
}