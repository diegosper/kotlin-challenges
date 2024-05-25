package diego.dev.ort.tp3.kotlin_challenges.entities

import android.os.Parcel

class Pokemon(
    id: Int,
    name: String,
    weight: Int,
    picture : String

){

    var id : Int
    var name : String
    var weight : Int
    var picture : String

    constructor(parcel: Parcel) : this (
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!

    )

    init {
        this.id = id
        this.name = name
        this.weight = weight
        this.picture = picture
    }
}