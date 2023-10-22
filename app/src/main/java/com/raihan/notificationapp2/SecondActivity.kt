package com.raihan.notificationapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raihan.notificationapp2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.text.text = intent.getStringExtra("DATA_REC")
    }
}