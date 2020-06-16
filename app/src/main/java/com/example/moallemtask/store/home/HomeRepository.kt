package com.example.moallemtask.store.home

import com.example.moallemtask.store.homemodel.SubjectsModel
import com.example.moallemtask.store.homemodel.VideosModel

class HomeRepository(mLocalDataStorage: LocalDataStorage){
    private var localDataStorage = mLocalDataStorage
    fun getSubjectsFromDB() :List<SubjectsModel>{
        return localDataStorage.getSubjectsFromLocalStorage()
    }
    fun getVideosFromDB() :List<VideosModel>{
        return localDataStorage.getVideosFromLocalStorage()
    }

}