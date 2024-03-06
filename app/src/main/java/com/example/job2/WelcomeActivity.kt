package com.example.job2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()
        actionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@WelcomeActivity,ProfileListActivity::class.java)
            startActivity(intent)
            finishAffinity()
        },2500)
        val t = WindowInsetsControllerCompat(window,window.decorView)
        t.hide(WindowInsetsCompat.Type.statusBars())
    }
}