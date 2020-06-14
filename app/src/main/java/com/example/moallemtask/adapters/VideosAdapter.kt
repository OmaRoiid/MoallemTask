package com.example.moallemtask.adapters
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.moallemtask.R
import com.example.moallemtask.listeners.OnClickedListener


class VideosAdapter(private val mContext : Context,  val videosList: List<Int>,private val mOnClickedListener: OnClickedListener,private val mType:String,private val mPackageName:String) : RecyclerView.Adapter<VideosAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideosAdapter.MyViewHolder {
        val mVideoCardView: View =
            LayoutInflater.from(mContext).inflate(R.layout.videos_card, parent, false)
        return MyViewHolder(mVideoCardView)
    }
    override fun getItemCount(): Int = videosList.size
    override fun onBindViewHolder(holder: VideosAdapter.MyViewHolder, position: Int) = holder.bind(position)

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mVideoView = itemView.findViewById<VideoView>(R.id.video_view)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(position: Int) {
            // seekTo () to make video thumbnail image
            val uri: Uri = Uri.parse( "android.resource://$mPackageName/${videosList[position]}")
            mVideoView.setVideoURI(uri)
            mVideoView.setOnPreparedListener {
                mVideoView.seekTo(1)
            }
        }
        override fun onClick(v: View?) {
            mOnClickedListener.onClickedItem(adapterPosition,mType)
        }


    }
}