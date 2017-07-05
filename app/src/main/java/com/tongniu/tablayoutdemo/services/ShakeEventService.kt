package com.tongniu.tablayoutdemo.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorEventListener2
import android.hardware.SensorListener
import android.hardware.SensorManager
import android.os.IBinder
import android.support.annotation.IntDef

/**
 * Created by tongniu on 2017/6/5.
 */

class ShakeEventService : Service() {
    private var sManager: SensorManager? = null

    override fun onCreate() {
        super.onCreate()
        /*  Intent broadcastIntent = new Intent("com.tongniu.tablayoutdemo.services");
        sendBroadcast(broadcastIntent);*/
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        sManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor = sManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sManager!!.registerListener(object : SensorEventListener {

            override fun onSensorChanged(event: SensorEvent) {

            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

            }
        }, sensor, SensorManager.SENSOR_DELAY_NORMAL)

        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        /*     Intent broadcastIntent = new Intent("com.tongniu.tablayoutdemo.services");
        sendBroadcast(broadcastIntent);*/
    }
}
