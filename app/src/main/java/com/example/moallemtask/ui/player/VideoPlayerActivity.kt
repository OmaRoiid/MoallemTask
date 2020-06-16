package com.example.moallemtask.ui.player
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.MediaController
import android.widget.RelativeLayout
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.moallemtask.R

class VideoPlayerActivity : AppCompatActivity() {
    private lateinit var clickedVideoView :VideoView
    private lateinit var mVideoUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        //passed video
        val mClickedVideoPath = intent.extras!!.getInt("clickedVideo")
        setupVideoPlayer(mClickedVideoPath)
    }

    private fun setupVideoPlayer(videoPath:Int){
        clickedVideoView = findViewById(R.id.clicked_video)
        //setting width and height of video automatic for portrait and landscape of the screen
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        clickedVideoView.layoutParams = RelativeLayout.LayoutParams(
            metrics.widthPixels,
            metrics.heightPixels
        )
        //Add Video Controller -> play, pause and stop video
        val mediaController = MediaController(this)
        mediaController.setMediaPlayer(clickedVideoView)
        clickedVideoView.setMediaController(mediaController)
        mVideoUri= Uri.parse("android.resource://$packageName/$videoPath")
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