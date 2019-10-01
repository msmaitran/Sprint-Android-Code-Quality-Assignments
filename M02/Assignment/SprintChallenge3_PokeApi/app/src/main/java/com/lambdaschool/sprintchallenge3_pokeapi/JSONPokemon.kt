package com.lambdaschool.sprintchallenge3_pokeapi

import android.graphics.Bitmap
import org.json.JSONException
import org.json.JSONObject

import java.io.Serializable
import java.util.ArrayList

data class JSONPokemon (
        val name: String,
        val sprites: Sprites,
        val id: Int,
        val abilities: List<PokemonAbility>,
        val types: List<PokemonType>
)

data class Sprites (val front_default: String)

data class PokemonAbility (val ability: Ability)
data class Ability (val name: String)

data class PokemonType (val type: Type)
data class Type (val name: String)

data class PokemonData (
        var name: String,
        var sprites: String,
        var id: Int,
        var abilities: MutableList<String>,
        var types: MutableList<String>
): Serializable