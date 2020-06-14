package com.example.moallemtask.ui.home

import com.example.moallemtask.ui.home.IView

class Presenter( iView: IView) {
    var mIView: IView = iView
  fun initHomeScreenViews(){
      mIView.initSubjectsList()
      mIView.initVideosList()
  }
}