package diego.dev.ort.tp3.kotlin_challenges.entities

import android.os.Parcel
import android.os.Parcelable

class Contacto(nombre: String, telefono: String, email: String, direccion: String, foto: String) {

    var nombre: String
    var telefono: String
    var email: String
    var direccion: String
    var foto: String

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    init {
        this.nombre = nombre
        this.telefono = telefono
        this.email = email
        this.direccion = direccion
        this.foto = foto
    }

}