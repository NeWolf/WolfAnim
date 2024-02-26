package com.newolf.animdemo

import android.content.Context
import android.content.Intent

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
object Navigater {
    fun startDurationActivity(context: Context) {
        context.startActivity(Intent(context,DurationActivity::class.java))
    }
}