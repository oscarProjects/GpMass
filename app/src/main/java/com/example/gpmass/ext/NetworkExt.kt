package com.example.gpmass.ext

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.gpmass.R
import com.google.android.material.snackbar.Snackbar

fun isNetworkAvailable(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    if(!isConnected){
        showSnackError(context as Activity, context.getString(R.string.no_internet_error))
    }
    return isConnected
}

private fun showSnackError(activity: Activity, message: String){
    try {
        val view = activity.window?.decorView
        val snack = view?.let { Snackbar.make(it, message, Snackbar.LENGTH_LONG) }
        val viewSnack = snack?.view
        viewSnack?.setBackgroundColor(ContextCompat.getColor(activity, R.color.teal_200))
        val params = viewSnack?.layoutParams as FrameLayout.LayoutParams
        params.setMargins(0, getStatusBarHeight(activity), 0, 0)
        params.gravity = Gravity.CENTER
        viewSnack.layoutParams = params
        snack.show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun getStatusBarHeight(context: Context): Int {
    var size = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        size = context.resources.getDimensionPixelSize(resourceId)
    }
    return size
}