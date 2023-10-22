package com.raihan.notificationapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raihan.notificationapp2.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = intent.getStringExtra("Data_next")
    }
}