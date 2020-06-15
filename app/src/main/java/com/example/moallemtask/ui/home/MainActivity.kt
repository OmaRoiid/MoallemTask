package com.example.moallemtask.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.adapters.SubjectsAdapter
import com.example.moallemtask.adapters.VideosAdapter
import com.example.moallemtask.listeners.OnVideosClickedListener
import com.example.moallemtask.ui.player.VideoPlayerActivity

class MainActivity : AppCompatActivity(), IView, OnVideosClickedListener {
    private lateinit var mMainPresenter: MainPresenter
    private lateinit var mSubjectsAdapter: SubjectsAdapter
    private lateinit var mVideosAdapter: VideosAdapter
    private val mSubjectsNameList :List<String> = arrayListOf("Physics","Biology","History","Algebra","Programming")
    private val mVideosList :List<Int> = arrayListOf(R.raw.videoone,R.raw.videotwo,R.raw.videothree)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         mMainPresenter= MainPresenter(this)
         mMainPresenter.initHomeScreenViews()
    }
    override fun initSubjectsList() {
        val subjectsList = findViewById<RecyclerView>(R.id.subjects_list)
        subjectsList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mSubjectsAdapter = SubjectsAdapter(this, mSubjectsNameList)
        subjectsList.adapter = mSubjectsAdapter
    }
    override fun initVideosList() {
        val videosList = findViewById<RecyclerView>(R.id.videos_list)
        videosList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mVideosAdapter =VideosAdapter(this, mVideosList,this)
        videosList.adapter = mVideosAdapter
    }
    override fun onVideoItemClicked(mVideoPath: Int) {
        val mDisplayActivity = Intent(this, VideoPlayerActivity::class.java)
                mDisplayActivity.putExtra("clickedVideo", mVideoPath)
                startActivity(mDisplayActivity)
    }
}