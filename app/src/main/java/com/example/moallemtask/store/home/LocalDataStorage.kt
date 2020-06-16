package com.example.moallemtask.store.home

import com.example.moallemtask.R
import com.example.moallemtask.store.homemodel.SubjectsModel
import com.example.moallemtask.store.homemodel.VideosModel

class LocalDataStorage {

    fun getSubjectsFromLocalStorage() :List<SubjectsModel>{
        return arrayListOf(
            SubjectsModel("Physics"),
            SubjectsModel("Biology"),
            SubjectsModel("History"),
            SubjectsModel("Algebra"),
            SubjectsModel("Programming")
        )
    }
    fun getVideosFromLocalStorage() :List<VideosModel>{
        return arrayListOf(
            VideosModel(R.raw.videoone),
            VideosModel(R.raw.videotwo),
            VideosModel(R.raw.videothree)
        )
    }
}