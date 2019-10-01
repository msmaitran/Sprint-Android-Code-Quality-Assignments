package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        names_list_layout

        search_button.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", (search_bar as EditText).text.toString())
            startActivityForResult(intent, 0)
        }
    }

    private fun buildTextView(name: String?): TextView {
        val view = TextView(this)
        view.text = name
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        view.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", name)
            startActivityForResult(intent, 0)
        }
        view.setOnLongClickListener { clickedView ->
            names_list_layout?.removeView(clickedView)
            true
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> {
                    val pokemon = data!!.getSerializableExtra("pokemon") as JSONPokemon
                    names_list_layout?.addView(buildTextView(pokemon.name))
                }
            }
        }
    }
}
