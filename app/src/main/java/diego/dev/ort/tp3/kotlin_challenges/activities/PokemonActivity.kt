package diego.dev.ort.tp3.kotlin_challenges.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.customview.widget.ViewDragHelper.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.model.PaginateResponse
import diego.dev.ort.tp3.kotlin_challenges.model.Pokemon
import diego.dev.ort.tp3.kotlin_challenges.service.ActivityServiceApiBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log

lateinit var txtPokemon1 : TextView
lateinit var txtPokemon2 : TextView
lateinit var recPokemones : RecyclerView
class SuperheroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pokemones)

        txtPokemon1 = this.findViewById(R.id.txt1)
        txtPokemon2 = this.findViewById(R.id.txt2)
        recPokemones = this.findViewById(R.id.rec_pokemones)

        cargarPokemones()



    }


    override fun onStart() {
        super.onStart()

        recPokemones.setHasFixedSize(true)


        //Diseño un layout para determina la orientación de mi lista
        //Si no lo defino, es horizonntal
        //Como parámetro le tengo que pasar el contexto (de fragmento o activity)
        //El contecto sería "el padre" que lo contiene. Puede ser similar a decir "activity", pero no en todos los casos.
        val linearLayoutManager = LinearLayoutManager(this )
        recPokemones.layoutManager = linearLayoutManager

        
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
}