package com.lambdaschool.sprintchallenge3_pokeapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

object PokemonDao {

    interface PokemonAPI {

        @GET("pokemon/{name-id}")
        fun getPokemon(@Path("name-id") nameOrId: String) : Call<JSONPokemon>
    }

    private val POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/%s/" // add pokemon name as

    fun getPokemon(name: String): Call<JSONPokemon> {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .retryOnConnectionFailure(false)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(POKEMON_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        return retrofit.create(PokemonAPI::class.java).getPokemon(name)
    }
}
