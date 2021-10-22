package com.example.mvpv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpv2.ItemClick
import com.example.mvpv2.MyDataItem
import com.example.mvpv2.R
import kotlinx.android.synthetic.main.item_ticket.view.*
import java.util.ArrayList

class RecyclerAdapter(private val itemClick: ItemClick,): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var userList = ArrayList<MyDataItem>()


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tv_from: TextView = itemView.tv_from
        var tv_to: TextView =itemView.tv_to
        var tv_price: TextView =itemView.tv_price
        var tv_from_city: TextView =itemView.tv_from_city
        var tv_to_city: TextView =itemView.tv_to_city

    }

    fun updateList(list: ArrayList<MyDataItem>) {
        userList.clear()
        userList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_from.text=userList[position].from
        holder.tv_to.text=userList[position].to
        holder.tv_price.text=userList[position].price
        holder.tv_from_city.text=userList[position].from_city
        holder.tv_to_city.text=userList[position].to_city
        holder.itemView.setOnClickListener {
            itemClick.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}