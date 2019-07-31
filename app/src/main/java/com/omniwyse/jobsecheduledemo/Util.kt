package com.omniwyse.jobsecheduledemo

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

/**
 * Created by Chandra Kant on 28/11/18.
 */
object Util {
    var count =0
    @RequiresApi(api = Build.VERSION_CODES.M)
    fun scheduleJob(context: Context) {
        val serviceComponent = ComponentName(context, TestJobService::class.java)
        val builder = JobInfo.Builder(0, serviceComponent)
        builder.setMinimumLatency((3 * 1000).toLong()) // wait at least
        builder.setOverrideDeadline((30 * 1000).toLong()) // maximum delay
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        //builder.setRequiresCharging(false); // we don't care if the device is charging or not
        val jobScheduler = context.getSystemService(JobScheduler::class.java)
        jobScheduler.schedule(builder.build())
        count += 1
        Log.e("TestJobService", "Count $count")

    }
}
