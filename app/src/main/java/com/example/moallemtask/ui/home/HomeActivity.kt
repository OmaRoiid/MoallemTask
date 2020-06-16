package com.example.moallemtask.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.adapters.SubjectsAdapter
import com.example.moallemtask.adapters.VideosAdapter
import com.example.moallemtask.listeners.OnVideosClickedListener
import com.example.moallemtask.store.home.HomeRepository
import com.example.moallemtask.store.home.LocalDataStorage
import com.example.moallemtask.ui.player.VideoPlayerActivity

class HomeActivity : AppCompatActivity(), IHomeActivity, OnVideosClickedListener
    {
 private lateinit var mHomePresenter: HomePresenter
 private lateinit var mSubjectsAdapter: SubjectsAdapter
 private lateinit var mVideosAdapter: VideosAdapter
 private lateinit var mDrawerLayout: DrawerLayout
 private lateinit var mCustomToggleIcon :ImageView
 private val mLocalDataStorage= LocalDataStorage()
 private val mHomeRepository = HomeRepository(mLocalDataStorage)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
         mHomePresenter= HomePresenter(this,mHomeRepository)
         mHomePresenter.create()
    }
    override fun setupToolbarCustomToggleIcon(){
            mDrawerLayout = findViewById(R.id.drawer_layout)
            mCustomToggleIcon=findViewById(R.id.iv_toggle)
            mCustomToggleIcon.setOnClickListener{ mDrawerLayout.openDrawer(GravityCompat.END) }
        }
    override fun setupSubjectsList() {
        val subjectsList = findViewById<RecyclerView>(R.id.subjects_list)
        subjectsList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mSubjectsAdapter = SubjectsAdapter(this,mHomePresenter.getSubjectsNamesList())
        subjectsList.adapter = mSubjectsAdapter
    }
    override fun setupVideosList() {
        val videosList = findViewById<RecyclerView>(R.id.videos_list)
        videosList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mVideosAdapter =VideosAdapter(this,mHomePresenter.getVideosPathsList(),this)
        videosList.adapter = mVideosAdapter
    }
    override fun onVideoItemClicked(mVideoPath: Int) {
        val mDisplayActivity = Intent(this, VideoPlayerActivity::class.java)
                mDisplayActivity.putExtra("clickedVideo", mVideoPath)
                startActivity(mDisplayActivity)
    }
}