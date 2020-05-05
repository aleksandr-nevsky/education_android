package cc.nevsky.education.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cc.nevsky.education.android.utils.CommonUtils

/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity() {
    private val listOfFilms = CommonUtils().generateFilmsList()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MY", "onCreate");
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
        recycler.adapter = FilmsAdapter(LayoutInflater.from(this), listOfFilms)

        // Если дошли до конца списка - кладём в список ещё пачку.
        recycler.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(layoutManager.findLastVisibleItemPosition() == listOfFilms.size) {
                    listOfFilms.addAll(CommonUtils().generateFilmsList())
                    recycler.adapter?.notifyItemRangeChanged(listOfFilms.size - 10, 10)
                }
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
    }

}