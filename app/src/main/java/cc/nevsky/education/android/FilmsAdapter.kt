package cc.nevsky.education.android

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_films.view.*

/**
 * Адаптер фильмов.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.05
 */
class FilmsAdapter(
    private val inflater: LayoutInflater,
    private val items: List<FilmsItem>,
    private val listener: OnFilmsClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            return FilmsItemViewHolder(inflater.inflate(R.layout.item_films, parent, false))
        } else {
            return HeaderFilmViewHolder(inflater.inflate(R.layout.item_films_header, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return items.size +
                1 // header
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FilmsItemViewHolder) {
            val filmsItem: FilmsItem = items[position - 1] // -1 header
            holder.bind(filmsItem)
            holder.itemView.setOnClickListener {
                listener.onFilmClick(
                    filmsItem, position - 1, holder.titleTv
                )
            }
            holder.itemView.detailBtn.setOnClickListener { listener.onDetailClick(filmsItem) }

            holder.itemView.setOnLongClickListener {
                listener.onFilmLongClick(filmsItem)
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    interface OnFilmsClickListener {
        fun onFilmClick(filmsItem: FilmsItem, position: Int, titleTv: TextView)
        fun onDetailClick(filmsItem: FilmsItem)
        fun onFilmLongClick(filmsItem: FilmsItem)
    }
}