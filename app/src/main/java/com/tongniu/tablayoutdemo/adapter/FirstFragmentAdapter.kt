package com.tongniu.tablayoutdemo.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * Created by tongniu on 2017/6/2.
 */

class FirstFragmentAdapter(private val list: ArrayList<ImageView>) : PagerAdapter() {
    var imageview: ImageView?=null
    override fun getCount(): Int {
        return Integer.MAX_VALUE
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var post = position%list.size
        if (position < 0) {
            post = list.size + position
        }
        val view = list.get(post)
        view.setScaleType(ImageView.ScaleType.FIT_XY)
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        val vp = view.parent
        if (vp != null) {
            val v = vp as ViewGroup
           v.removeView(view)
        }
        container.addView(view)
        view.setOnClickListener {

        }
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }
}
