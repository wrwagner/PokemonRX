package com.rodrigues.wagner.pokemonrx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.bumptech.glide.Glide
import com.rodrigues.wagner.pokemonrx.R
import com.rodrigues.wagner.pokemonrx.model.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(val context: Context,
                     val jogos: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pokemon,
                parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val jogo = jogos[position]
        holder.let {
            it.bindView(jogo)
        }
    }

    class PokemonViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        fun bindView(jogo: Pokemon) = with(itemView) {
            tvNome.text = jogo.name
            //tvAno.text = jogo.ano.toString()
            Glide.with(context).load(jogo.sprites.frontDefalt).into(ivPokemon)
        }
    }

}