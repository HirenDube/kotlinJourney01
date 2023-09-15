package com.example.kotlinjourney1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NavigatingGridAdapter(context: Context, _itemList: List<String>, _activityList: List<Intent>) : BaseAdapter() {
    var itemList = _itemList
    var context = context
    var activityList = _activityList
    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }


    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layoutInflator: LayoutInflater? = null
        var layout = convertView
        layoutInflator = layoutInflator ?: context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        layout = layout ?: layoutInflator!!.inflate(R.layout.item_layout,null)

        var pageDetails : TextView = layout!!.findViewById(R.id.pageDetails)
         var goto : Intent = activityList[position]
        pageDetails.text = itemList[position]
        return layout
    }
}