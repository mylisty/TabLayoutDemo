package com.tongniu.tablayoutdemo

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.tongniu.tablayoutdemo.adapter.BaseListAdapter
import com.tongniu.tablayoutdemo.adapter.FirstFragmentAdapter
import com.tongniu.tablayoutdemo.services.OnBootReceiver
import com.tongniu.tablayoutdemo.services.ShakeEventService
import com.tongniu.tablayoutdemo.wiegt.Present


/**
 * Created by tongniu on 2017/4/1.
 */

class FirstFragment : Fragment() {
  //  private val imageIds = intArrayOf(R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e)
    private val imageUrls = arrayOf("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg")
    var viewpager: ViewPager?=null
    var arraylist: ArrayList<ImageView>?=null
    var imageViewList: ArrayList<ImageView>?=null
    var linearlayout: LinearLayout?= null
    var listViw:Present?= null
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
    /*      when (msg.what) {
                1 -> count++
            }*/
            viewpager!!.setCurrentItem(viewpager!!.currentItem+1)
            this.sendEmptyMessageDelayed(1,2000)
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.firstfragment, container, false)
        viewpager= view.findViewById(R.id.fgt_viewpager) as ViewPager
        linearlayout = view.findViewById(R.id.linearlayout) as LinearLayout
        listViw = view.findViewById(R.id.listview) as Present
        val service = Intent(context, ShakeEventService::class.java)
        context.startService(service)
        registSreenStatusReceiver()
        /*arraylist= arrayListOf<ImageView>()
        for (imageId in imageIds) {
            val image:ImageView = ImageView(activity)
            image.setBackgroundResource(imageId)
            arraylist!!.add(image)

        }*/
        imageViewList = arrayListOf<ImageView>()
            for(image in imageUrls){
            val imageview:ImageView = ImageView(context)
                Glide.with(context)
                        .load(image)
                        .into(imageview)
                imageViewList!!.add(imageview)
        }
        viewpager!!.adapter = FirstFragmentAdapter(imageViewList!!)

        viewpager!!.setCurrentItem(20000)
        handler.sendEmptyMessageDelayed(1,2000)
        listInitview()
        return view
    }

    private fun listInitview() {
        listViw!!.adapter =  BaseListAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
        context.unregisterReceiver(onBootReceiver1)
    }

    private val onBootReceiver1: OnBootReceiver
        get() {
            val onBootReceiver = OnBootReceiver()
            return onBootReceiver
        }

    private fun registSreenStatusReceiver() {
        val onBootReceiver = onBootReceiver1
        val screenStatusIF = IntentFilter()
        screenStatusIF.addAction(Intent.ACTION_SCREEN_ON)
        screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF)
        context.registerReceiver(onBootReceiver, screenStatusIF)
    }
}
