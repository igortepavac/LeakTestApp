package com.example.leaktestapp

import android.app.Application
import leakcanary.LeakCanary

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val c = LeakCanary.config.copy(retainedVisibleThreshold = 2)
        LeakCanary.config = c
    }
}