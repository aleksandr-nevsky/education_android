package cc.nevsky.education.android

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.my_custom_dialog.*
import kotlin.system.exitProcess

/**
 * Custom диалог для закрытия приложения.
 *
 * @author Aleksandr Vvedenskiy
 * @date 2020.04
 */
class MyCustomDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_custom_dialog)
        val confirmButton = findViewById<Button>(R.id.confirmExitButton)
        val breakExitButton = findViewById<Button>(R.id.breakExitButton)
        breakExitButton.setOnClickListener {
            dismiss()
        }

        confirmButton.setOnClickListener {
            cancel()
        }
    }
}