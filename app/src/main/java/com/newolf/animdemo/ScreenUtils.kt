package com.newolf.animdemo

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
object ScreenUtils {
    fun getScreenWidth(): Int {
        return App.app.resources.displayMetrics.widthPixels
    }

}