package com.example.android_lab5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android_lab4.R
import com.example.android_lab4.databinding.ActivityMainBinding

import com.example.android_lab5.ui.fragments.event.EventsFragment
import com.example.android_lab4.fragments.HolidayFragment
import com.example.android_lab5.ui.fragments.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("msa", "Main created")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.BNEvents -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EventsFragment())
                        .commit()
                    true
                }
                R.id.BNHolidays -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HolidayFragment())
                        .commit()
                    true
                }
                R.id.BNProfile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }

    override fun onStop() {
        Log.d("msa", "Main is closed")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("msa", "Main destroyed")
        super.onDestroy()
    }
}