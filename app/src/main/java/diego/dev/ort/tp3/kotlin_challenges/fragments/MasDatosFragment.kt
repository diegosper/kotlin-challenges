package diego.dev.ort.tp3.kotlin_challenges.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import diego.dev.ort.tp3.kotlin_challenges.R


class MasDatosFragment : Fragment() {


    lateinit var viewMasDatos: View
    lateinit var btnProfile: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        var textoParaSnack = "HELLO WORLD!!!!"
        viewMasDatos = inflater.inflate(R.layout.fragment_mas_datos, container, false)
        btnProfile = viewMasDatos.findViewById(R.id.mas_datos_btn_profile)

        btnProfile.setOnClickListener {
            val actionToProfile =
                MasDatosFragmentDirections.actionMasDatosFragmentToProfileFragment(textoParaSnack)
            viewMasDatos.findNavController().navigate(actionToProfile)

        }



        return viewMasDatos
    }
}