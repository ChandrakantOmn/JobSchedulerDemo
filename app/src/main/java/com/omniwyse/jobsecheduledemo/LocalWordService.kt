package com.omniwyse.jobsecheduledemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

/**
 * Created by Chandra Kant on 28/11/18.
 */
class LocalWordService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, "LocalWordService", Toast.LENGTH_SHORT).show()
    }
}
