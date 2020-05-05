package cc.nevsky.education.android.unused

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.R

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    val subtitleTv: TextView = itemView.findViewById(R.id.subtitleTv)
    val imgIv: ImageView = itemView.findViewById(R.id.image)

    //    fun bind(title: String, subtitle: String, color: Int) {
//        titleTv.text = title
//        subtitleTv.text = subtitle
//        imgIv.setBackgroundColor(color)
//    }
    fun bind(item: NewsItem) {
        titleTv.text = item.title
        subtitleTv.text = item.subtitle
        imgIv.setBackgroundColor(item.color)
    }

}