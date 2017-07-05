package com.tongniu.tablayoutdemo.wiegt

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.tongniu.tablayoutdemo.R
import com.tongniu.tablayoutdemo.adapter.App
import org.w3c.dom.Text
import java.util.*

/**
 * Created by tongniu on 2017/6/6.
 */
class Present: ListView {
    var headView: TextView? = null
    var myview: View? = null
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        intiview()
    }
    init {

    }
    private fun intiview() {
         myview = View.inflate(context, R.layout.item,null)
        headView = TextView(App.getinstance.context)
        headView!!.text = "aaaaa"
        headView!!.setTextColor(Color.BLACK)
        headView!!.gravity= Gravity.CENTER
        headView!!.setPadding(0,-50,0,0)
        this.addHeaderView(headView)
        this.addFooterView(myview)
        myview!!.setPadding(0,0,0,-50)

        setOnScrollListener( object: AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                Log.i("aaaaa+visibleItemCount",visibleItemCount.toString())
                Log.i("aaaaa+totalItemCount",totalItemCount.toString())
                Log.i("aaaaa+firstVisibleItem",firstVisibleItem.toString())
            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                val lastVisiblePosition = view!!.lastVisiblePosition
                Log.i("aaaaa+lastVisiblePosition",lastVisiblePosition.toString())
                if (lastVisiblePosition==adapter.count-1){
                    getfoot()
                }
            }

        })
    }

    private fun getfoot() {
        myview!!.setPadding(0,0,0,0)
    }

    var startx:Int? = null
    var starty:Int? = null


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev!!.action){
            MotionEvent.ACTION_DOWN -> {
                startx= ev.getX().toInt()
                starty = ev.getY().toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                var moveY = ev.getY().toInt()
                var moveHight:Int? = null
                if (starty!=null){
                    moveHight = moveY- starty!!
                }
                if (moveHight!=null && moveHight>50){
                    moveHight = 50
                }
                headView!!.setPadding(0,moveHight!!.toInt()-50,0,0)
            }
            MotionEvent.ACTION_UP -> {
                headView!!.setPadding(0,-50,0,0)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

}