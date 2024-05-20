package diego.dev.ort.tp3.kotlin_challenges.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.fragments.ProfileFragment

class GymActivity : AppCompatActivity() {

    private lateinit var btmNavView : BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gym)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.gym_nav_host) as NavHostFragment
        btmNavView = findViewById(R.id.btm_nav_gym)


        /*
        Helper que ya viene de androidx.
        El NavigationUI es quien se encarga de escribir el código
        */
        NavigationUI.setupWithNavController(btmNavView, navHostFragment.navController)

    }
}