package com.rodrigues.wagner.pokemonrx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.GridLayout
import com.rodrigues.wagner.pokemonrx.adapter.PokemonAdapter
import com.rodrigues.wagner.pokemonrx.api.PokemonAPI
import com.rodrigues.wagner.pokemonrx.api.PokemonService
import com.rodrigues.wagner.pokemonrx.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var adapter :PokemonAdapter

    val pokemons = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = PokemonService()

        adapter = PokemonAdapter(this, pokemons)
        rvListaPokemon.adapter = adapter
        rvListaPokemon.layoutManager = LinearLayoutManager(this)

        api.loadPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            pokemons.add(it)
                            //Log.i("POKEMON","${it.name} - ${it.sprites.frontDefalt}")
                        },
                        {e -> e.printStackTrace()},
                        {
                            adapter.notifyDataSetChanged()
                            //Log.i("POKEMON","Todos Pokemons emitidos")
                        }
                )
    }
}
