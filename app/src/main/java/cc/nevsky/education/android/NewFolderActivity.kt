package cc.nevsky.education.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_folder.*

class NewFolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_folder)

        val value = getIntent().getIntExtra("name", 0)
        when (value) {
            1 -> {
                this.filmView.setImageResource(R.drawable.new_folder)
                this.description.setText(R.string.new_folder_description)
            }
            2 -> {
                this.filmView.setImageResource(R.drawable.new_folder_2)
                this.description.setText(R.string.new_folder2_description)

            }
            3 -> {
                this.filmView.setImageResource(R.drawable.new_folder_3)
                this.description.setText(R.string.new_folder3_description)
            }
            else -> {
            }
        }

    }
}
