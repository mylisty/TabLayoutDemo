package com.tongniu.tablayoutdemo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by tongniu on 2017/4/1.
 */

class FirstFragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(context)
        textView.text = "firstfragment2"
        // inflater.inflate(R.layout.activity_main,container);
        val viewPager: ViewPager
        return textView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
}
