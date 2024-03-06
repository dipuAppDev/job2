package com.example.job2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.job2.databinding.ActivitySingleProfileBinding

class SingleProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySingleProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }
    private fun getIntentData() {
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        binding.apply {
            nameTxt.text = name
            addressTxt.text = address
            cityTxt.text = city
        }
    }
}