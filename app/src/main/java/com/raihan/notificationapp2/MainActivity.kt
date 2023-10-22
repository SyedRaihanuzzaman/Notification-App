package com.raihan.notificationapp2

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.raihan.notificationapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this,MainActivity::class.java)
        val intentNext = Intent(this@MainActivity, NextActivity::class.java)
        val intentPlay = Intent(this@MainActivity, PlayActivity::class.java)
        val intentBack = Intent(this@MainActivity, BackActivity::class.java)

        binding.btnHigh.setOnClickListener {
            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID1)
            notification.setContentTitle(binding.tittle.text.toString())
            notification.setContentText(binding.content.text.toString())

            intent.putExtra("DATA_REC",binding.content.text.toString())
            intentNext.putExtra("Data_next",binding.content.text.toString())
            intentPlay.putExtra("Data_play", binding.content.text.toString())
            intentBack.putExtra("Data_back", binding.content.text.toString())

            val pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_MUTABLE)
            val NextIntent = PendingIntent.getActivity(this@MainActivity, 0, intentNext, PendingIntent.FLAG_MUTABLE)
            val PlayIntent = PendingIntent.getActivity(this@MainActivity, 0, intentPlay, PendingIntent.FLAG_MUTABLE)
            val BackIntent = PendingIntent.getActivity(this@MainActivity, 0, intentBack, PendingIntent.FLAG_MUTABLE)

            notification.setSmallIcon(R.drawable.up)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.up,"Back",BackIntent)
                .addAction(R.drawable.up,"Play",PlayIntent)
                .addAction(R.drawable.up,"Next",NextIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())
        }
        binding.btnLow.setOnClickListener {
            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.tittle.text.toString())
            notification.setContentText(binding.content.text.toString())
            notification.setSmallIcon(R.drawable.down)
            notification.setPriority(NotificationCompat.PRIORITY_LOW)
                .build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())
        }
    }
}