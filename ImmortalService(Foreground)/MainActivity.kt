package com.example.immortalservice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceIntent = Intent(this, ImmortalService::class.java)

        findViewById<Button>(R.id.startBtn).setOnClickListener{
            startService(serviceIntent)
        }

        findViewById<Button>(R.id.stopBtn).setOnClickListener{
            stopService(serviceIntent)
        }
    }
}
