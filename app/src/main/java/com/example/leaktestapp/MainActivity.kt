package com.example.leaktestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import leakcanary.LeakCanary

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("LeakCanary", "onCreate $this")

        findViewById<Button>(R.id.action).setOnClickListener {
            Log.e("LeakCanary", "Click $this")
            viewModel.drop("1234") {
                Log.e("LeakCanary", "Toast $this")
                Toast.makeText(this, "Got $it", Toast.LENGTH_SHORT).show()
            }
        }
    }
}