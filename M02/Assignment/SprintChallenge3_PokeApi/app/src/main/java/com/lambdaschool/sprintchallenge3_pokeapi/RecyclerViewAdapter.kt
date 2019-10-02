package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.sprintchallenge3_pokeapi.Constants.POKEMON_INTENT_KEY
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class RecyclerViewAdapter (val searchedPokemons: MutableList<PokemonData>) :
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var context: Context? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.tv_saved_list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val viewGroup = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return searchedPokemons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pokemonName.text = searchedPokemons[position].name
        holder.pokemonName.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra(POKEMON_INTENT_KEY, searchedPokemons[position])
            (context as Activity).startActivity(intent)
        }
        holder.pokemonName.setOnLongClickListener {
            searchedPokemons.removeAt(position)
            notifyItemRemoved(position)
            true
        }
    }
}