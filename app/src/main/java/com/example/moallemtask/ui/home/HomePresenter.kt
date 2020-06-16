package com.example.moallemtask.ui.home
import com.example.moallemtask.store.home.HomeRepository
import com.example.moallemtask.store.homemodel.SubjectsModel
import com.example.moallemtask.store.homemodel.VideosModel

class HomePresenter(iHomeActivity: IHomeActivity,homeRepository: HomeRepository) {
    private var mHomeRepository = homeRepository
    private val mIHomeActivity = iHomeActivity
  fun create(){
      mIHomeActivity.setupToolbarCustomToggleIcon()
      mIHomeActivity.setupSubjectsList()
      mIHomeActivity.setupVideosList()
  }
    fun getSubjectsNamesList() :List<SubjectsModel>{
       return mHomeRepository.getSubjectsFromDB()
    }
    fun getVideosPathsList() :List<VideosModel>{
        return mHomeRepository.getVideosFromDB()
    }
}