package com.example.android_lab5.ui.fragments.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lab4.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}