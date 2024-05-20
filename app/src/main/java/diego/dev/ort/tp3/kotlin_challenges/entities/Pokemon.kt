package diego.dev.ort.tp3.kotlin_challenges.entities

import android.os.Parcel

class Pokemon(nombre: String?){

    var nombre : String

    //Hago la clase PARCELEABLE
    //Tengo que asignar los atributos parceleables en el orden que los recibo

    constructor(parcel: Parcel) : this (
        parcel.readString()
    )

    init {
        this.nombre = nombre!!
    }
}