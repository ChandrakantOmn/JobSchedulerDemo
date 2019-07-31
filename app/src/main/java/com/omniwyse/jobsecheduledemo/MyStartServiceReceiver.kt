package com.omniwyse.jobsecheduledemo

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi


/**
 * Created by Chandra Kant on 28/11/18.
 */
class MyStartServiceReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onReceive(context: Context, intent: Intent) {
        Util.scheduleJob(context)
    }
}
