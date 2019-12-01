package com.dafa_190808_gugug.demo

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author pengyanming
 * @date 2019/12/1.
 * Email：916193549@QQ.COM
 */
class SimpAdapter(var itemWidth: Int, var itemMarg: Int) : RecyclerView.Adapter<MyVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simp_item, parent, false)
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return 600
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val layoutParams = holder.imageView.layoutParams as LinearLayout.LayoutParams
        layoutParams.width = itemWidth
        layoutParams.height = itemWidth
        layoutParams.gravity = Gravity.CENTER
        layoutParams.setMargins(itemMarg, itemMarg, itemMarg, itemMarg)
        holder.imageView.layoutParams = layoutParams
        holder.imageView.setText("${position}")
    }
}

class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView = itemView.findViewById<TextView>(R.id.tvName)

}
