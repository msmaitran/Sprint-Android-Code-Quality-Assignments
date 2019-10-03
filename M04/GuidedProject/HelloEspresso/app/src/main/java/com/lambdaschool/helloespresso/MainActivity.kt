package com.lambdaschool.helloespresso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TITLE = "TITLE_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        change_title_button.setOnClickListener {
            title_view.text = getTitleInput()
        }

        pass_title_button.setOnClickListener {
            val newTitle = getTitleInput()

            title_view.text = newTitle

            val intent = Intent(this@MainActivity, TODO())
            intent.putExtra(KEY_TITLE, newTitle)
            startActivity(intent)
        }
    }

    private fun getTitleInput() = title_input.text.toString()
}
