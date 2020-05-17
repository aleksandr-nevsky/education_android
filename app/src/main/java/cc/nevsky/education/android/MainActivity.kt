package cc.nevsky.education.android

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cc.nevsky.education.android.filmsFragments.FilmsDetailedFragment
import cc.nevsky.education.android.filmsFragments.FilmsListFragment
import cc.nevsky.education.android.goAhead.NewsDetailedFragment
import cc.nevsky.education.android.goAhead.NewsListFragment
import com.otus.otusfragmentsnew.recyclerTwo.NewsItem

/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity(), FilmsListFragment.FilmsListListener {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = FilmsListFragment();
        fragment.listener = this
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment, NewsListFragment.TAG)
            .commit()


//        initRecycler()
//        initClickListeners()
    }

    private fun openNewsDetailedFragment(newsItem: NewsItem) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                NewsDetailedFragment.newInstance(newsItem.title),
                NewsDetailedFragment.TAG
            )
            .addToBackStack(null) // Возврат к предыдущему фрагменту
            .commit()
    }

    private fun openFilmDetailedFragment(filmsItem: FilmsItem) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                FilmsDetailedFragment.newInstance(filmsItem),
                FilmsDetailedFragment.TAG
            )
            .addToBackStack(null) // Возврат к предыдущему фрагменту
            .commit()
    }

//    override fun onNewsSelect(newsItem: NewsItem) {
//        openNewsDetailedFragment(newsItem)
//    }

    override fun onDetailClick(filmsItem: FilmsItem) {
        openFilmDetailedFragment(filmsItem)
    }

    override fun onAddToFavoriteClick(filmsItem: FilmsItem) {
        MyStorage.favoriteList.add(filmsItem)
        Toast.makeText(
            applicationContext,
            "${filmsItem.title} добавлен в избранное.",
            Toast.LENGTH_SHORT
        ).show()
    }


//    /**
//     * Инициализация recycler.
//     */
//    private fun initRecycler() {
//        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recycler.layoutManager = layoutManager
//        recycler.adapter = FilmsAdapter(LayoutInflater.from(this), MyStorage.listOfFilms,
//            object : FilmsAdapter.OnFilmsClickListener {
//                override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
//                    // region вызов активити с описанием
//                    val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
//                    intent.putExtra("title", filmsItem.title)
//                    intent.putExtra("shortDescription", filmsItem.shortDescription)
//                    intent.putExtra("pictureId", filmsItem.pictureId)
//                    startActivity(intent)
//                    // endregion
//                }
//
//                override fun onFilmLongClick(filmsItem: FilmsItem) {
//                    Log.i(TAG, "onFilmLongClick")
//                    MyStorage.favoriteList.add(filmsItem)
//                    Toast.makeText(applicationContext, "${filmsItem.title} добавлен в избранное.", Toast.LENGTH_LONG).show()
//                }
//
//                override var usageAs: String = "list"
//            })
//
//
//
//        // Если дошли до конца списка - кладём в список ещё пачку.
//        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                if (layoutManager.findLastVisibleItemPosition() == MyStorage.listOfFilms.size) {
//                    MyStorage.listOfFilms.addAll(CommonUtils().generateFilmsList())
//                    recycler.adapter?.notifyItemRangeChanged(MyStorage.listOfFilms.size - 10, 10)
//                }
//                findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout).isRefreshing = false
//            }
//        })
//
//        // Добавляем разделители
//        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        itemDecoration.setDrawable(getDrawable(R.drawable.brown_line_2dp)!!)
//        recycler.addItemDecoration(itemDecoration)
//    }
//
//    /**
//     * Инициализация ClickListeners.
//     */
//    private fun initClickListeners() {
//        // Неявное приглашение друга.
//        findViewById<View>(R.id.inviteFriendBtn).setOnClickListener {
//            val textMessage = "Hello, friend!"
//            val sendIntent = Intent()
//            sendIntent.action = Intent.ACTION_SEND
//            sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage)
//            sendIntent.type = "text/plain"
//            val title = resources.getString(R.string.app_name)
//            // Создаем Intent для отображения диалога выбора.
//            val chooser = Intent.createChooser(sendIntent, title)
//            // Проверяем, что intent может быть успешно обработан
//            sendIntent.resolveActivity(packageManager)?.let {
//                startActivity(chooser)
//            }
//        }
//
//        findViewById<View>(R.id.favoriteBtn).setOnClickListener {
//            val intent = Intent(this@MainActivity, FavoriteListActivity::class.java)
////            intent.putExtra("title", filmsItem.title)
//
//            startActivity(intent)
//        }
//    }
}