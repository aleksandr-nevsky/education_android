package cc.nevsky.education.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cc.nevsky.education.android.utils.CommonUtils

/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MyApp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initClickListeners()
    }


    /**
     * Инициализация recycler.
     */
    private fun initRecycler() {
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = FilmsAdapter(LayoutInflater.from(this), MyStorage.listOfFilms,
            object : FilmsAdapter.OnFilmsClickListener {
                override fun onDetailClick(filmsItem: FilmsItem, position: Int) {
                    // region вызов активити с описанием
                    val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
                    intent.putExtra("title", filmsItem.title)
                    intent.putExtra("shortDescription", filmsItem.shortDescription)
                    intent.putExtra("pictureId", filmsItem.pictureId)
                    startActivity(intent)
                    // endregion
                }

                override fun onFilmLongClick(filmsItem: FilmsItem) {
                    Log.i(TAG, "onFilmLongClick")
                    MyStorage.favoriteList.add(filmsItem)
                    Toast.makeText(applicationContext, "${filmsItem.title} добавлен в избранное.", Toast.LENGTH_LONG).show()
                }

                override var usageAs: String = "list"
            })



        // Если дошли до конца списка - кладём в список ещё пачку.
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (layoutManager.findLastVisibleItemPosition() == MyStorage.listOfFilms.size) {
                    MyStorage.listOfFilms.addAll(CommonUtils().generateFilmsList())
                    recycler.adapter?.notifyItemRangeChanged(MyStorage.listOfFilms.size - 10, 10)
                }
                findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout).isRefreshing = false
            }
        })

        // Добавляем разделители
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(getDrawable(R.drawable.brown_line_2dp)!!)
        recycler.addItemDecoration(itemDecoration)
    }

    /**
     * Инициализация ClickListeners.
     */
    private fun initClickListeners() {
        // Неявное приглашение друга.
        findViewById<View>(R.id.inviteFriendBtn).setOnClickListener {
            val textMessage = "Hello, friend!"
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage)
            sendIntent.type = "text/plain"
            val title = resources.getString(R.string.app_name)
            // Создаем Intent для отображения диалога выбора.
            val chooser = Intent.createChooser(sendIntent, title)
            // Проверяем, что intent может быть успешно обработан
            sendIntent.resolveActivity(packageManager)?.let {
                startActivity(chooser)
            }
        }

        findViewById<View>(R.id.favoriteBtn).setOnClickListener {
            val intent = Intent(this@MainActivity, FavoriteListActivity::class.java)
//            intent.putExtra("title", filmsItem.title)

            startActivity(intent)
        }
    }
}