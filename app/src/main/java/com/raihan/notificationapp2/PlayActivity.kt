package com.raihan.notificationapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raihan.notificationapp2.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = intent.getStringExtra("Data_play")
    }
}