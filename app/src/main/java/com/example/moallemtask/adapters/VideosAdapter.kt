package com.example.moallemtask.adapters
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.listeners.OnVideosClickedListener
import com.example.moallemtask.store.homemodel.VideosModel


class VideosAdapter(private val mContext : Context, private val videosList: List<VideosModel>, private val mOnVideosClickedListener: OnVideosClickedListener) : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideosAdapter.VideosViewHolder {
        val mVideoCardView: View =
            LayoutInflater.from(mContext).inflate(R.layout.video_card, parent, false)
        return VideosViewHolder(mVideoCardView)
    }
    override fun getItemCount(): Int = videosList.size
    override fun onBindViewHolder(holder: VideosAdapter.VideosViewHolder, position: Int) = holder.bind(position)

    inner class VideosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mVideoView = itemView.findViewById<VideoView>(R.id.video_view)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(position: Int) {
            // seekTo ()-> to make video thumbnail image
            val uri: Uri = Uri.parse( "android.resource://${mContext.packageName}/${videosList[position].mVideoPath}")
            mVideoView.setVideoURI(uri)
            mVideoView.setOnPreparedListener {
                mVideoView.seekTo(1)
            }
        }
        override fun onClick(v: View?) {
            mOnVideosClickedListener.onVideoItemClicked(videosList[adapterPosition].mVideoPath)
        }


    }
}