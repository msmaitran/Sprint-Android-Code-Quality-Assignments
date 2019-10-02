package com.lambdaschool.sprintchallenge3_pokeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lambdaschool.sprintchallenge3_pokeapi.Constants.POKEMON_INTENT_KEY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonData = intent.getSerializableExtra(POKEMON_INTENT_KEY) as PokemonData
        val abilities = pokemonData.abilities.toString().replace("[", "").replace("]", "")
        val types = pokemonData.types.toString().replace("[", "").replace("]","")

        tv_pokemon_name.text = "${pokemonData.name}"
        tv_pokemon_id.text = "ID: ${pokemonData.id}"
        Picasso.get().load(pokemonData.sprites).into(iv_pokemon_sprite)
        tv_pokemon_abilities.text = "Abilities: $abilities"
        tv_pokemon_types.text = "Types: $types"
    }
}
