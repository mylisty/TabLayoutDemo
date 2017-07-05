package com.tongniu.tablayoutdemo.adapter

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by tongniu on 2017/6/7.
 */
class BaseListAdapter: BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = TextView(App.getinstance.context)
        view.text = "dddddddddddddddd"
        view.setTextSize(20.0F)
        view.setTextColor(Color.BLACK)
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
       return 20
    }
}