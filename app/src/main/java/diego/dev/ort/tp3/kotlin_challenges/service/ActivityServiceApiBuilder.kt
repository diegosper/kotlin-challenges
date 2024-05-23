package diego.dev.ort.tp3.kotlin_challenges.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//Llamada para construir mi objeto con retrofit
//CREO UNA INSTANCIA (singleton) QUE ADENTRO CREA UNA CAPA DE SERVICIOS,
// que a su vez implementa métodos a partir de la insterfaz de servicios
object ActivityServiceApiBuilder {

    private val BASE_URL = "https://pokeapi.co"

    //Creo un objeto retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create () : PokemonService {
        return retrofit.create(PokemonService::class.java)
    }
}