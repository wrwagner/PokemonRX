package com.rodrigues.wagner.pokemonrx.api


import com.rodrigues.wagner.pokemonrx.model.Pokemon
import com.rodrigues.wagner.pokemonrx.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface PokemonAPI {
    @GET("/api/v2/pokemon")
    fun listaPokemon(): Observable<PokemonListResponse>

    @GET("/api/v2/pokemon/{nomePokemon}")
    fun buscarPor(@Path("nomePokemon") nomePokemon: String)
        : Observable<Pokemon>
}