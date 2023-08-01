package com.example.gpmass.common.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gpmass.common.base.constants.GpMassConstants.ACTIVITY_MAIN
import com.example.gpmass.ui.main.MainActivity


open class BaseActivity : AppCompatActivity() {

    fun onNavigateActivity(idView: String?, bundle: Bundle? = null) {
        try {
            var intent: Intent? = null
            when (idView) {
                ACTIVITY_MAIN   -> intent = Intent(this, MainActivity::class.java)
            }
            bundle?.let { intent?.putExtras(it) }
            intent?.flags =  Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}