package com.example.moallemtask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R

class SubjectsAdapter(private val mContext : Context,  private val subjectsList: List<String>) : RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectsAdapter.SubjectsViewHolder {
        val mSubjectCardView: View = LayoutInflater.from(mContext).inflate(R.layout.subject_card,parent,false)
        return SubjectsViewHolder(mSubjectCardView)
    }
    override fun getItemCount(): Int = subjectsList.size
    override fun onBindViewHolder(holder: SubjectsAdapter.SubjectsViewHolder, position: Int) = holder.bind(position)

    inner class SubjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val mSubjectTitle=itemView.findViewById<TextView>(R.id.tv_subject_title)
        fun bind(position: Int){
            mSubjectTitle.text=subjectsList[position]
        }
    }
}