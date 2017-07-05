package com.tongniu.tablayoutdemo.adapter

import android.app.Application
import android.content.Context
import com.tongniu.tablayoutdemo.adapter.App.getinstance.context

/**
 * Created by tongniu on 2017/6/5.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }
    object getinstance  {
         var context: Context?=null
    }
}