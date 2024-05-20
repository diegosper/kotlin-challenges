package diego.dev.ort.tp3.kotlin_challenges.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import diego.dev.ort.tp3.kotlin_challenges.R


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({

            //EJEMPLO CON URI
            //val intentUri = Intent(Intent.ACTION_CALL, Uri.parse("tel:911"))

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            //PONGO EL FINISH PORQE SÉ QUE NO LA VOY A USAR NUNCA MÁS
            //Si no hiciera el finish, cuando pongo la flechista de "atrás" me volvería a esta pantalla
        }, 3000)
    }
}