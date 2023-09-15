package com.example.kotlinjourney1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageTaskGrIdAdapter(context: Context, _itemList: List<String>, ) : BaseAdapter() {
    var itemList = _itemList
    var context = context

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

        layout = layout ?: layoutInflator!!.inflate(R.layout.image_task_grid_layout,null)

        var pageImage : ImageView = layout!!.findViewById(R.id.gridImage)
        Picasso.get().load(itemList[position]).into(pageImage);

        return layout
    }
}
