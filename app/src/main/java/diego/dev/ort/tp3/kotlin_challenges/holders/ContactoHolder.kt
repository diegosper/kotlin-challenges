package diego.dev.ort.tp3.kotlin_challenges.holders

import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import diego.dev.ort.tp3.kotlin_challenges.R

class ContactoHolder(viewHolder: View) : RecyclerView.ViewHolder(viewHolder) {

    private var view : View

    init {
        this.view = viewHolder
    }

    fun setNombre (nombre: String){
        val txt : TextView = view.findViewById(R.id.txtNombre)
        txt.text = nombre
    }

    fun setTelefono (telefono: String){
        val txt : TextView = view.findViewById(R.id.txtTelefono)
        txt.text = telefono
    }

    fun setEmail (email: String){
        val txt : TextView = view.findViewById(R.id.txtEmail)
        txt.text = email
    }

    fun setAvatar (url: String){
        /*val img : ImageView = view.findViewById(R.id.imgAvatar)
        img.setImageResource(url)*/
    }

    fun getCardLayout () : View {
        return view.findViewById(R.id.cardViewContacto)
    }

}