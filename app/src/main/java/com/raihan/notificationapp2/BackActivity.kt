package com.raihan.notificationapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raihan.notificationapp2.databinding.ActivityBackBinding

class BackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBackBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = intent.getStringExtra("Data_back")
    }
}