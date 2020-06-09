package cc.nevsky.education.android.exitToInternet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.FilmsItem
import cc.nevsky.education.android.R
import kotlinx.android.synthetic.main.item_films.view.*

class FilmsAdapter(
    private val inflater: LayoutInflater,
    private val items: List<FilmsItem>,
    private val listener: OnFilmsClickListener
//    private val items: List<FilmsItem>
//) : RecyclerView.Adapter<FilmsViewHolder>() {
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)
        )
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        if (viewType == VIEW_TYPE_ITEM) {
//            return FilmsViewHolder(inflater.inflate(R.layout.item_films, parent, false))
//        } else {
//            return HeaderFilmViewHolder(inflater.inflate(R.layout.item_films_header, parent, false))
//        }
//    }

    override fun getItemCount(): Int {
//        return items.size +
//                1 // header
        return items.size
    }

//    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
//        holder.bind(items[position])
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is FilmsItemViewHolder) {
        if (holder is FilmsViewHolder) {
//            val filmsItem: FilmsItem = items[position - 1] // -1 header
            val filmsItem: FilmsItem = items[position]
//            holder.bind(filmsItem)
            holder.bind(items[position])



            holder.itemView.detailBtn.setOnClickListener {
                listener.onDetailClick(
                    filmsItem,
                    holder.adapterPosition
                )
            }

            holder.itemView.setOnLongClickListener {
                listener.onFilmLongClick(filmsItem)
                return@setOnLongClickListener true
            }

            when (listener.usageAs) {
                "list" -> holder.itemView.detailBtn.text =
                    inflater.context.getString(R.string.detail)
                "favorite" -> holder.itemView.detailBtn.text =
                    inflater.context.getString(R.string.delete)
            }
        }

    }

//    override fun getItemViewType(position: Int): Int {
//        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
//    }
//
    interface OnFilmsClickListener {
        fun onDetailClick(filmsItem: FilmsItem, position: Int)
        fun onFilmLongClick(filmsItem: FilmsItem)

        var usageAs: String
    }
}