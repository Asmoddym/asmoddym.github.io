package net.noparking.projects.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextViewAdapter(private val context: Context, items: List<TextView>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private var _items: List<TextView>
    init {
        _items = items
    }

    override fun getCount(): Int {
        return _items.size
    }

    override fun getItem(i: Int): Any {
        return _items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, parent: ViewGroup): View? {
        return _items[i]
    }
}
