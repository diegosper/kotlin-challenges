package diego.dev.ort.tp3.kotlin_challenges.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.activities.MainActivity
import diego.dev.ort.tp3.kotlin_challenges.activities.SuperheroesActivity
import diego.dev.ort.tp3.kotlin_challenges.activities.btn_login


class MasDatosFragment : Fragment() {


    lateinit var viewMasDatos: View
    lateinit var btnProfile: Button
    lateinit var btnContactos : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        var textoParaSnack = "HELLO WORLD!!!!"
        viewMasDatos = inflater.inflate(R.layout.fragment_mas_datos, container, false)
        btnProfile = viewMasDatos.findViewById(R.id.mas_datos_btn_profile)
        btnContactos = viewMasDatos.findViewById(R.id.btn_contactos)

        btnProfile.setOnClickListener {
            val actionToProfile =
                MasDatosFragmentDirections.actionMasDatosFragmentToProfileFragment(textoParaSnack)
            viewMasDatos.findNavController().navigate(actionToProfile)

        }

        val txt_click = viewMasDatos.findViewById<TextView>(R.id.txt_click)
        txt_click.setOnClickListener(){
            val intent2 = Intent(viewMasDatos.context, SuperheroesActivity::class.java)
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent2.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent2)
            //finish()
        }

        btnContactos.setOnClickListener {
            val actionToContactos =
                MasDatosFragmentDirections.actionMasDatosFragmentToContactosFragment()

            viewMasDatos.findNavController().navigate(actionToContactos)
        }


        return viewMasDatos
    }
}