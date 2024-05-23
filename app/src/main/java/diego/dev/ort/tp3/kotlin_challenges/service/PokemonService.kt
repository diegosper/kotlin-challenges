package diego.dev.ort.tp3.kotlin_challenges.service

import diego.dev.ort.tp3.kotlin_challenges.model.PaginateResponse
import diego.dev.ort.tp3.kotlin_challenges.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("api/v2/pokemon")
    fun getPokemon() : Call<PaginateResponse<Pokemon>>
    //CALL es un método de retrofit, que se utiliza para devolver la llamda de datos
    //DEL TIPO GENERICS (T)
    //Si veo lo que me devuelve el endpoint: un objeto grande y dentro tiene un array con varios objetos. Lo traduzco con Generics:


    @GET("api/v2/ability")
    fun getPokemonAbility()

}