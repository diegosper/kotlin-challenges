package diego.dev.ort.tp3.kotlin_challenges.model

//UNA DATA CLASS ES UN OBJETO QUE VOY A LLENAR Y NO VOY A ESTAR MANIPULANDO DESPUÉS. ES MÁS BÁSICO
//NO HACE FALTA AGREGAR TODAS LAS PROPIEDADES DEL OBJETO. SOLO LAS QUE QUIERO UTILIZAR
data class PaginateResponse<T>(
    val count: Int,
    val next: String?,
    val previous: String?, //PUEDE SER NULL
    val results: List<T>
    //EL TIPO T SERÁ EL QUE YO LE PASE POR CONSTRUCTOR (puede ser POKEMON o cualquier otro)
)

