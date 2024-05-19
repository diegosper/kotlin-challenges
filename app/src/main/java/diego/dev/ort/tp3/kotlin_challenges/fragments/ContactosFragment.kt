package diego.dev.ort.tp3.kotlin_challenges.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.adapters.ContactoAdapter
import diego.dev.ort.tp3.kotlin_challenges.entities.Contacto

lateinit var viewContactos : View
lateinit var recContactos : RecyclerView
private var contactos : MutableList<Contacto> = ArrayList()


class ContactosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewContactos = inflater.inflate(R.layout.fragment_contactos, container, false)

        recContactos = viewContactos.findViewById(R.id.rec_contactos)



        return viewContactos
    }

    override fun onStart() {
        super.onStart()

        for (i in 1..10){
            contactos.add(Contacto("Diego", "611008592", "diego.sper@hotmail.com", "Florencio Balcarce 32", "http://google.com"))
            contactos.add(Contacto("Laia", "1199887766", "laia.jeba@hotmail.com", "Rambla 54", "http://google.com"))

        }

        requireActivity().title = "Prueba"

        recContactos.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val contactosAdapter = ContactoAdapter(contactos)

        recContactos.layoutManager = linearLayoutManager
        recContactos.adapter = contactosAdapter


    }

}