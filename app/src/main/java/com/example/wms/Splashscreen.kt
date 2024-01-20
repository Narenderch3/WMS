package com.example.wms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        val splashScreenDuration = 3000
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, mainpage::class.java))
            finish()
        }, splashScreenDuration.toLong())
    }
}
