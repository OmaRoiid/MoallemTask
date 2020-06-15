package com.example.moallemtask.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.adapters.SubjectsAdapter
import com.example.moallemtask.adapters.VideosAdapter
import com.example.moallemtask.listeners.OnClickedListener
import com.example.moallemtask.ui.player.VideoPlayerActivity


class MainActivity : AppCompatActivity(), IView,OnClickedListener {
    private  val TYPE_ONE="SUBJECT"
    private lateinit var mPresenter: Presenter
    private lateinit var mSubjectsAdapter: SubjectsAdapter
    private lateinit var mVideosAdapter: VideosAdapter
    private val mSubjectsNameList :List<String> = arrayListOf("Physics","Biology","History","Algebra","Programming")
    private val mVideosList :List<Int> = arrayListOf(R.raw.videoone,R.raw.videotwo,R.raw.videothree)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         mPresenter= Presenter(this)
         mPresenter.initHomeScreenViews()
    }
    override fun initVideosList() {
        val videosList = findViewById<RecyclerView>(R.id.videos_list)
        videosList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mVideosAdapter =VideosAdapter(this, mVideosList,this)
        mVideosAdapter.notifyDataSetChanged()
        videosList.adapter = mVideosAdapter
    }
    override fun initSubjectsList() {
        val subjectsList = findViewById<RecyclerView>(R.id.subjects_list)
        subjectsList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mSubjectsAdapter = SubjectsAdapter(this, mSubjectsNameList,this)
        mSubjectsAdapter.notifyDataSetChanged()
        subjectsList.adapter = mSubjectsAdapter
    }
    override fun onClickedItem(position: Int, mType:String) {
        if(mType==TYPE_ONE) {
            Toast.makeText(this, "Subject : ${mSubjectsAdapter.subjectsList[position]}",Toast.LENGTH_SHORT).show()
        } else {
            val mClickedVideoPath = mVideosAdapter.videosList[position]
                val mDisplayActivity = Intent(this, VideoPlayerActivity::class.java)
                mDisplayActivity.putExtra("clickedVideo",mClickedVideoPath)
                startActivity(mDisplayActivity)
        }
    }
}