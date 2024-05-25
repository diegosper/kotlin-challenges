package diego.dev.ort.tp3.kotlin_challenges.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.model.PaginateResponse
import diego.dev.ort.tp3.kotlin_challenges.service.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Response
import diego.dev.ort.tp3.kotlin_challenges.entities.Pokemon

lateinit var txtPokemon1 : TextView
lateinit var txtPokemon2 : TextView
lateinit var imgPokemon: ImageView
lateinit var recPokemones : RecyclerView
var listaPokemones: MutableList<Pokemon> = ArrayList()

private var pokemones : MutableList<Pokemon> = ArrayList()
class SuperheroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pokemones)

        txtPokemon1 = this.findViewById(R.id.txt1)
        txtPokemon2 = this.findViewById(R.id.txt2)
        imgPokemon = this.findViewById(R.id.img_pokemon)
        recPokemones = this.findViewById(R.id.rec_pokemones)

        //cargarPokemones()
        cargarPokemonsHard(listaPokemones)




    }


    override fun onStart() {
        super.onStart()

        recPokemones.setHasFixedSize(true)


        //Diseño un layout para determina la orientación de mi lista
        //Si no lo defino, es horizonntal
        //Como parámetro le tengo que pasar el contexto (de fragmento o activity)
        //El contecto sería "el padre" que lo contiene. Puede ser similar a decir "activity", pero no en todos los casos.
        val linearLayoutManager = LinearLayoutManager(this )
        //SI NO LO DEFINO, ES HORIZONTAL
        recPokemones.layoutManager = linearLayoutManager
        txtPokemon1.text = listaPokemones.get(2).name
        txtPokemon2.text = listaPokemones.get(2).weight.toString()
        val imgUrl = listaPokemones.get(2).picture
        Glide.with(this).load(imgUrl).into(imgPokemon)


        
    }


    fun cargarPokemones(){

        val service = ActivityServiceApiBuilder.create()

        service.getPokemon().enqueue(object : retrofit2.Callback<PaginateResponse<Pokemon>>{

            override fun onResponse(call: Call<PaginateResponse<Pokemon>>, response: Response<PaginateResponse<Pokemon>>) {
            if(response.isSuccessful){
                val responsePokemon = response.body()

                txtPokemon1.text = responsePokemon?.count.toString()
                txtPokemon2.text = responsePokemon?.results?.get(1)?.name.toString()
            }
        }
            override fun onFailure(p0: Call<PaginateResponse<Pokemon>>, p1: Throwable) {
                finish()
            }


        })
    }

    fun cargarPokemonsHard(listaPokemones: MutableList<Pokemon>){
        for(i in 1..9){

            val pokemon = Pokemon(
                i,
                "Ricardito",
                30,
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${i}.png"
            )

            listaPokemones.add(pokemon)
        }
    }
}