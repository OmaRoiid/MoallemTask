package com.example.moallemtask.ui.player
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.moallemtask.R


class VideoPlayerActivity : AppCompatActivity() {
    private lateinit var clickedVideoView :VideoView
    private lateinit var mVideoUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        //Passed video
        val mClickedVideoPath = intent.extras!!.getInt("clickedVideo")
         clickedVideoView = findViewById(R.id.clicked_video)
         //Add Video Controller -> play, pause and stop video
        val mediaController = MediaController(this)
        mediaController.setMediaPlayer(clickedVideoView)
        clickedVideoView.setMediaController(mediaController)
        mVideoUri= Uri.parse("android.resource://$packageName/$mClickedVideoPath")
        clickedVideoView.setVideoURI(mVideoUri)
        clickedVideoView.start()
        clickedVideoView.setOnPreparedListener { mp ->
            mp.setOnVideoSizeChangedListener { _, _, _ ->
               //add media controller
                clickedVideoView.setMediaController(mediaController)
                // and set its position on screen
                mediaController.setAnchorView(clickedVideoView)
            }
        }
    }
}