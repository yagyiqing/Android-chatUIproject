package com.example.uibestpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(val Msglist:List<Msg>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class LeftViewHolder(view: View):RecyclerView.ViewHolder(view){
        val leftMsg:TextView=view.findViewById(R.id.leftMsg)
    }
    inner class RightViewHolder(view: View):RecyclerView.ViewHolder(view){
        val rightMsg:TextView=view.findViewById(R.id.rightMsg)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = Msglist[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=if(viewType == Msg.TYPE_RECEIVED){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item1,parent,false)
        LeftViewHolder(view) }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item2,parent,false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = Msglist[position]
        when(holder){
            is LeftViewHolder ->holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
            else ->throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = Msglist.size

}