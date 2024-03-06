package com.example.job2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.job2.databinding.ActivityAddProfileBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddProfileActivity : AppCompatActivity() {
    private val viewModel : ProfileViewModel by viewModels()
    private lateinit var binding: ActivityAddProfileBinding
    var id:Int = 0
    var code:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.createUserBtn.setOnClickListener {
            val username = binding.nameEt.text.toString()
            val address = binding.addressEt.text.toString()
            val city = binding.cityEt.text.toString()
            if (username.isNotEmpty() && address.isNotEmpty() && city.isNotEmpty()){
                if (code=="update"){
                    val uName = binding.nameEt.text.toString()
                    val uAddress = binding.addressEt.text.toString()
                    val uCity = binding.cityEt.text.toString()
                    if (uName.isNotEmpty() && uAddress.isNotEmpty() && uCity.isNotEmpty()){
                        GlobalScope.launch {
                            viewModel.updateProfile(uName,uAddress,uCity,id)
                        }
                        Toast.makeText(this, "Profile updated.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,ProfileListActivity::class.java))
                        finishAffinity()
                    }
                }
                else{
                    val profile = Profile(null,username,address,city)
                    GlobalScope.launch {
                        viewModel.insertProfile(profile)
                    }
                    Toast.makeText(this, "Profile created successfully.", Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(this,
                        ProfileListActivity::class.java
                    )
                    )
                    finishAffinity()
                }

            }
            else{
                Toast.makeText(this@AddProfileActivity, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
            }
        }
        getIntentData()
    }
    private fun getIntentData() {
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        id = intent.getIntExtra("id",0)
        code = intent.getStringExtra("code").toString()
        if (code=="update"){
            binding.apply {
                nameEt.setText(name)
                addressEt.setText(address)
                cityEt.setText(city)
                createUserBtn.text = "Update"
                titleText.text = "Update user profile"
            }
        }
    }
}