package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<JSONPokemon> {

    companion object {
        val POKEMON_INTENT_KEY = "pokemon"
    }

    val pokemonList = mutableListOf<PokemonData>()
    lateinit var pokemonDao: PokemonDao

    override fun onFailure(call: Call<JSONPokemon>, t: Throwable) {
        t.printStackTrace()
        val response = "Failure; ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<JSONPokemon>, response: Response<JSONPokemon>) {
        if (response.isSuccessful) {
            val jsonPokemon = response.body() as JSONPokemon
            val abilities = mutableListOf<String>()
            jsonPokemon.abilities.forEach {
                abilities.add(it.ability.name)
            }

            val types = mutableListOf<String>()
            jsonPokemon.types.forEach {
                types.add(it.type.name)
            }

            val pokemonData = PokemonData(
                    jsonPokemon.name,
                    jsonPokemon.sprites.front_default,
                    jsonPokemon.id,
                    abilities,
                    types
            )

            pokemonList.add(pokemonData)
            rv_list.adapter!!.notifyDataSetChanged()

            val intent = Intent(this, PokemonDetailsActivity::class.java)
            intent.putExtra(POKEMON_INTENT_KEY, pokemonData)
            startActivity(intent)

        } else {
            val response = "Response not successful; ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
        }
    }

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
