package com.newolf.animdemo

import android.app.Application

/**
 * ======================================================================
 *
 *
 * @author : NeWolf
 * @version : 1.0
 * @since :  2024-02-06
 *
 * =======================================================================
 */
class App:Application() {
    companion object {
        lateinit var app:App
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}