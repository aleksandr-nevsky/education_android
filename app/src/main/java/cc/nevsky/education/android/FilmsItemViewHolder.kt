package cc.nevsky.education.android

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Класс хранения фильмов
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class FilmsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    val shortDescription: TextView = itemView.findViewById(R.id.shortDescriptionTv)
    val imgIv: ImageView = itemView.findViewById(R.id.imageIv)

    fun bind(item: FilmsItem) {
        titleTv.text = item.title
        shortDescription.text = item.shortDescription
//        imgIv.setImageURI(Uri.parse(item.imagePath))
        imgIv.setBackgroundResource(item.pictureId)

    }
}