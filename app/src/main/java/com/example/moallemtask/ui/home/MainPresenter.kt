package com.example.moallemtask.ui.home

import com.example.moallemtask.ui.home.IView

class MainPresenter(iView: IView) {
    private val mIView = iView
  fun initHomeScreenViews(){
      mIView.initSubjectsList()
      mIView.initVideosList()
  }
}