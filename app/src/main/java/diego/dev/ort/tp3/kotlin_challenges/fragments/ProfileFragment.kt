package diego.dev.ort.tp3.kotlin_challenges.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import diego.dev.ort.tp3.kotlin_challenges.R


class ProfileFragment : Fragment() {

    lateinit var viewProfile: View
    lateinit var btnGoToMasDatos: Button
    lateinit var btnTryMe: Button
    var textoParaSnack: String = "No hay texto para mostrar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewProfile = inflater.inflate(R.layout.fragment_profile, container, false)
        textoParaSnack = ""

        btnGoToMasDatos = viewProfile.findViewById(R.id.profile_btn_mas_datos)
        btnTryMe = viewProfile.findViewById<Button>(R.id.profile_btn_snack)

        btnGoToMasDatos.setOnClickListener() {
            val actionToMasDatos =
                ProfileFragmentDirections.actionProfileFragmentToMasDatosFragment()
            viewProfile.findNavController().navigate(actionToMasDatos)

        }

        return viewProfile
    }

    override fun onStart() {
        super.onStart()

        val parametros = ProfileFragmentArgs.fromBundle(requireArguments())


        if (parametros.unTexto == "") {
            textoParaSnack = "No hay texto para mostrar"
        } else {
            textoParaSnack = parametros.unTexto
        }

        btnTryMe.setOnClickListener() {
            Snackbar.make(it, textoParaSnack, Snackbar.LENGTH_SHORT).show()

        }

    }

}