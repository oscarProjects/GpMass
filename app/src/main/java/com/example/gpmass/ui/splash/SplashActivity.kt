package com.example.gpmass.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.example.gpmass.common.base.BaseActivity
import com.example.gpmass.common.base.constants.GpMassConstants.ACTIVITY_MAIN
import com.example.gpmass.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private var TAG: String = this::class.java.name
    private var splashTimer: CountDownTimer? = null
    private val minute = 5L

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        splashTimer = object : CountDownTimer(minute * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d(TAG, "millisUntilFinished $millisUntilFinished")
            }

            override fun onFinish() {
                binding.loadingAnimation.pauseAnimation()
                onNavigateActivity(ACTIVITY_MAIN)
            }
        }.start()
    }
}