package com.example.moallemtask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.listeners.OnClickedListener

class SubjectsAdapter(private val mContext : Context,  val subjectsList: List<String>, private val mOnClickedListener: OnClickedListener) : RecyclerView.Adapter<SubjectsAdapter.MyViewHolder>() {
    private  val TYPE_ONE="SUBJECT"
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectsAdapter.MyViewHolder {
        val mSubjectCardView: View = LayoutInflater.from(mContext).inflate(R.layout.subject_card,parent,false)
        return MyViewHolder(mSubjectCardView)
    }
    override fun getItemCount(): Int = subjectsList.size
    override fun onBindViewHolder(holder: SubjectsAdapter.MyViewHolder, position: Int) = holder.bind(position)

    inner class MyViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mSubjectTitle=itemView.findViewById<TextView>(R.id.tv_subject_title)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(position: Int){
            mSubjectTitle.text=subjectsList[position]
        }
        override fun onClick(v: View?) {
           mOnClickedListener.onClickedItem(adapterPosition,TYPE_ONE)
        }
    }
}