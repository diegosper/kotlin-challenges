package diego.dev.ort.tp3.kotlin_challenges.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import diego.dev.ort.tp3.kotlin_challenges.R


class ProfileFragment : Fragment() {

lateinit var viewProfile : View
lateinit var btnGoToMasDatos : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        viewProfile = inflater.inflate(R.layout.fragment_profile, container, false)

        btnGoToMasDatos = viewProfile.findViewById(R.id.profile_btn_mas_datos)

        btnGoToMasDatos.setOnClickListener(){
            val actionToMasDatos = ProfileFragmentDirections.actionProfileFragmentToMasDatosFragment()
            viewProfile.findNavController().navigate(actionToMasDatos)

        }


        return viewProfile
    }


}