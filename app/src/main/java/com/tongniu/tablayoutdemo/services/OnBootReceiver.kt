package com.tongniu.tablayoutdemo.services

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by tongniu on 2017/6/5.
 */

class OnBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        /*        ShakeEventService shakeEventService = new ShakeEventService();*/

        Log.i("aaaaaaaaaaaaaa", "onReceive: " + intent.action)
        if (intent.action == Intent.ACTION_TIME_TICK) {
            Log.i("aaaaaaaaaaaaaa", "onReceive: " + intent.action)
        }
        val service = Intent(context, ShakeEventService::class.java)
        if (!isMyServiceRunning(ShakeEventService::class.java, context)) {
            context.startService(service)
        }
        context.startService(service)
    }


    private fun isMyServiceRunning(serviceClass: Class<*>, context: Context): Boolean {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.i("isMyServiceRunning?", true.toString() + "")
                return true
            }
        }
        Log.i("isMyServiceRunning?", false.toString() + "")
        return false
    }
}
