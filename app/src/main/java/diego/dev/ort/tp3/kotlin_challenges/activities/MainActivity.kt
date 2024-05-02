package diego.dev.ort.tp3.kotlin_challenges.activities

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import diego.dev.ort.tp3.kotlin_challenges.R

class MainActivity : AppCompatActivity() {


    lateinit var btnImage : ImageView
    //NO USO EL LATEINIT APROVECHANO GENERICS MÁS ABAJO
    //Lo creo acá o no, en función si lo voy a necesitar en varios métodos o sólo dentro de uno de ellos.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnImage = findViewById(R.id.main_image)

        btnImage.setOnClickListener(){
            Snackbar.make(it,  "Hello!!", Snackbar.LENGTH_SHORT).show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



}