package com.example.job2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.job2.databinding.ActivityProfileListBinding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileListActivity : AppCompatActivity() {
    private val viewModel : ProfileViewModel by viewModels()
    private lateinit var binding: ActivityProfileListBinding
    private lateinit var adapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getAllProfile().observe(this@ProfileListActivity) {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = ProfileAdapter(it)
            binding.recyclerView.adapter = adapter
            adapter.setOnClickListener(object :ProfileAdapter.Listener{
                override fun onItemClick(position: Int, profile: Profile) {
                    val intent = Intent(this@ProfileListActivity,SingleProfileActivity::class.java)
                    intent.putExtra("name",profile.name)
                    intent.putExtra("address",profile.address)
                    intent.putExtra("city",profile.city)
                    startActivity(intent)
                }

                override fun onEditClick(position: Int, profile: Profile) {
                    val intent = Intent(this@ProfileListActivity,AddProfileActivity::class.java)
                    intent.putExtra("id",profile.id)
                    intent.putExtra("name",profile.name)
                    intent.putExtra("address",profile.address)
                    intent.putExtra("city",profile.city)
                    intent.putExtra("code","update")
                    startActivity(intent)
                }
                override fun onDeleteClick(position: Int, profile: Profile) {
                    GlobalScope.launch {
                        viewModel.deleteProfile(profile)
                    }
                    adapter.notifyItemRemoved(position)
                }

            })
            binding.totalProfile.text = it.size.toString()
        }
        binding.refreshBtn.setOnClickListener {
            startActivity(Intent(
                this,WelcomeActivity::class.java
            ))
        }
        binding.newProfileBtn.setOnClickListener {
            startActivity(
                Intent(
                this,AddProfileActivity::class.java
            )
            )
        }
    }
}