package com.dafa_190808_gugug.demo

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hhl.gridpagersnaphelper.GridPagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), PagerGridLayoutManager.PageListener {
    override fun onPageSizeChanged(pageSize: Int) {
        Toast.makeText(applicationContext, "${pageSize}", Toast.LENGTH_SHORT).show()

    }

    override fun onPageSelect(pageIndex: Int) {
        setLayout(pageIndex)

    }

    var itemWidth = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ScreenUtil.init(this)
        recycleView.setHasFixedSize(true)
        var mLayoutManager = PagerGridLayoutManager(
            2, 5, PagerGridLayoutManager
                .HORIZONTAL
        )
        // 水平分页布局管理器
        mLayoutManager.setPageListener(this)    // 设置页面变化监听器
        recycleView.layoutManager = mLayoutManager

        // 设置滚动辅助工具
        val pageSnapHelper = PagerGridSnapHelper()
        pageSnapHelper.attachToRecyclerView(recycleView)
        itemWidth = ScreenUtil.screenWidth / 60
        var width = (ScreenUtil.screenWidth - ScreenUtil.dip2px(50f)) / 5
        recycleView.adapter = SimpAdapter(width, ScreenUtil.dip2px(50f) / 20)

        setLayout(0)


        var gridLayoutManager =
            GridLayoutManager(applicationContext, 2, RecyclerView.HORIZONTAL, false)
        recycleview2.layoutManager = gridLayoutManager

        val gridPagerSnapHelper = GridPagerSnapHelper()
        gridPagerSnapHelper.setRow(2).setColumn(5)
        gridPagerSnapHelper.attachToRecyclerView(recycleview2)
        recycleview2.adapter = SimpAdapter(ScreenUtil.screenWidth / 5, 0)
        gridLayoutManager.spanSizeLookup
    }

    fun setLayout(index: Int) {
        val layoutParams = line.layoutParams as LinearLayout.LayoutParams
        layoutParams.width = itemWidth * (index + 1)
        line.layoutParams = layoutParams
    }
}
