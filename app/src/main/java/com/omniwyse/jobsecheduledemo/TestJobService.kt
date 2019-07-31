package com.omniwyse.jobsecheduledemo

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

/**
 * Created by Chandra Kant on 28/11/18.
 */
class TestJobService : JobService() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onStartJob(params: JobParameters): Boolean {
        val service = Intent(applicationContext, LocalWordService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            applicationContext.startForegroundService(service)
        } else {
            applicationContext.startService(service)
        }
        Util.scheduleJob(applicationContext) // reschedule the job
        //   Toast.makeText(applicationContext, "TestJobService", Toast.LENGTH_SHORT).show()
        Log.e("TestJobService", "TestJobService")
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        return true
    }

}
