package com.example.iteradmin.customlistview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlin.coroutines.experimental.coroutineContext

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<ListView>(R.id.ListView)
        val avenger = arrayOf("ant_man","barton","black_panther",
                "black_widow","captain_america","captain_marvel","hulk","iron_man","spyder_man","thor")
        val  real_name = arrayOf("Paul Rudd","barton", "chandwick","scarlet","Chris evans","brie larson","Edward","Robert","Tom Holland","Chris Hemsworth")
        val images = arrayOf(R.drawable.ant_man,R.drawable.barton,R.drawable.black_panther,R.drawable.black_widow,R.drawable.captain_america,R.drawable.captain_marvel,R.drawable.hulk,R.drawable.iron_man,R.drawable.spyder_man,R.drawable.thor)
        list.adapter = MyAdapter(this,avenger,real_name,images)
    }
    class MyAdapter(context: Context, n:Array<String>,o:Array<String>,p:Array<Int>): BaseAdapter() {
        private val mContext:Context
        private val name:Array<String>
        private val real:Array<String>
        private val img:Array<Int>
        init {
            mContext= context
            name=n
            real=o
            img=p
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
               val layout:LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
                val rootview = layout.inflate(R.layout.item,null,true)
            val itemView =rootview.findViewById<ImageView>(R.id.icon)
            val im = rootview.findViewById<ImageView>(R.id.icon)
            val txt = rootview.findViewById<TextView>(R.id.title)
            val subtxt = rootview.findViewById<TextView>(R.id.subtitle)
            im.setImageResource(img[position])
            txt.text = name[position]
            subtxt.text = real[position]
            return rootview
        }

        override fun getItem(position: Int): Any {
            return "anything"

        }

        override fun getItemId(position: Int): Long {
        return position.toLong()
        }

        override fun getCount(): Int {
        return name.size
        }
    }


}
