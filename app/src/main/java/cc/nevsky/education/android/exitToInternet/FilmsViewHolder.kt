package cc.nevsky.education.android.exitToInternet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.FilmsItem
import cc.nevsky.education.android.R
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_films.view.*

/**
 * Класс ViewHolder.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.06
 */
class FilmsViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
    override val containerView: View?
        get() = itemView

    fun bind(item: FilmsItem) {
        itemView.titleTv.text = item.title

        Glide.with(itemView.imageIv.context)
            .load(item.image)
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_error)
            .override(itemView.imageIv.resources.getDimensionPixelSize(R.dimen.image_size))
            .centerCrop()
            .into(itemView.imageIv)
    }
}