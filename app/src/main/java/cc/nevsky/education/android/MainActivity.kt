package cc.nevsky.education.android

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Главная Activity.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MY", "onCreate");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.colorizeFilmLabel()
    }

    /**
     * Клик по кнопке первого фильма.
     */
    fun onNfClick(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 1)
        MyStorage.filmId = 1
        colorizeFilmLabel()
        startActivity(intent)
    }

    /**
     * Клик по кнопке второго фильма.
     */
    fun onNf2Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 2)
        MyStorage.filmId = 2
        colorizeFilmLabel()

        startActivity(intent)
    }

    /**
     * Клик по кнопке третьего фильма.
     */
    fun onNf3Click(view: View?) {
        val intent = Intent(this@MainActivity, NewFolderActivity::class.java)
        intent.putExtra("name", 3)
        MyStorage.filmId = 3
        colorizeFilmLabel()

        startActivity(intent)
    }

    /**
     * Неявное приглашение друга.
     */
    fun onImplicitInviteFriend(view: View?) {
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

    /**
     * Отмечаем цветом выбранный фильм.
     */
    private fun colorizeFilmLabel() {
        Log.i("MY", "Storage.filmId = " + MyStorage.filmId);
        this.textView.setTextColor(Color.BLACK)
        this.textView2.setTextColor(Color.BLACK)
        this.textView3.setTextColor(Color.BLACK)
        when (MyStorage.filmId) {
            1 -> this.textView.setTextColor(Color.BLUE)
            2 -> this.textView2.setTextColor(Color.BLUE)
            3 -> this.textView3.setTextColor(Color.BLUE)
        }
    }
}
