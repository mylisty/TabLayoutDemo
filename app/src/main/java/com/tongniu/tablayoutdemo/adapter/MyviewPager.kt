package com.tongniu.tablayoutdemo.adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by tongniu on 2017/6/2.
 */

class MyviewPager : ViewPager {
    private var startX: Int = 0
    private var startY: Int = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        //请求父控件不拦截事件
        //parent.requestDisallowInterceptTouchEvent(true)
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                //按下
                startX = ev.x.toInt()
                startY = ev.y.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                //移动
                val endX = ev.x.toInt()
                val endY = ev.y.toInt()

                val dx = endX - startX
                val dy = endY - startY

                if (Math.abs(dx) > Math.abs(dy)) {
                    //左右滑动
                    val currentItem = currentItem

                    if (dx > 0) {
                        //右划
                        if (currentItem == 0) {
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    } else {
                        //左划
                        //getChildCount()
                        val count = adapter.count//当前viewpager item总数
                        if (currentItem == count - 1) {
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    }

                } else {
                    //上下滑动
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }

            else -> {
            }
        }

        return super.dispatchTouchEvent(ev)
    }

}
