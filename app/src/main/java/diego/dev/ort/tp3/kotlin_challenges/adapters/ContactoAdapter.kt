package diego.dev.ort.tp3.kotlin_challenges.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import diego.dev.ort.tp3.kotlin_challenges.R
import diego.dev.ort.tp3.kotlin_challenges.entities.Contacto
import diego.dev.ort.tp3.kotlin_challenges.holders.ContactoHolder

class ContactoAdapter (
    private val contactos : MutableList<Contacto>
) : RecyclerView.Adapter<ContactoHolder> () {

    //Opcion 1
    //override fun getItemCount(): Int {
    //    return contactos.size
    //}
    //
    // o

    //opcion 2:
    override fun getItemCount() = contactos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contacto, parent, false)
        return ContactoHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {
        val contacto = contactos[position]

        holder.setNombre(contacto.nombre)
        holder.setTelefono(contacto.telefono)
        holder.setEmail(contacto.email)
        //holder.setAvatar(contacto.foto)


    }


}