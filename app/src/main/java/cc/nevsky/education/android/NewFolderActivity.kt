package cc.nevsky.education.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_folder.*

/**
 * Activity с описанием.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class NewFolderActivity : AppCompatActivity() {

    /**
     * Отрисовываем в зависимости от передаваемых параметров.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_folder)

        val pictureId = getIntent().getIntExtra("pictureId", 0)
        val description = getIntent().getStringExtra("shortDescription")

        this.filmView.setImageResource(pictureId)
        this.description.setText(description)
    }

}