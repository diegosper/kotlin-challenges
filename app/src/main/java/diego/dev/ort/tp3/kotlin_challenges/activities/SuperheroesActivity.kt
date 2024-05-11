package diego.dev.ort.tp3.kotlin_challenges.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import diego.dev.ort.tp3.kotlin_challenges.R

lateinit var recSuperheroes : RecyclerView
class SuperheroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superheroes)

        recSuperheroes = this.findViewById(R.id.rec_superheroes)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onStart() {
        super.onStart()

        recSuperheroes.setHasFixedSize(true)


        //Diseño un layout para determina la orientación de mi lista
        //Si no lo defino, es horizonntal
        //Como parámetro le tengo que pasar el contexto (de fragmento o activity)
        //El contecto sería "el padre" que lo contiene. Puede ser similar a decir "activity", pero no en todos los casos.
        val linearLayoutManager = LinearLayoutManager(this )
        recSuperheroes.layoutManager = linearLayoutManager

        
    }
}