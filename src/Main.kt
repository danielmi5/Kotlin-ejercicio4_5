import obtenerOperacion

fun obtenerTiempo(): Tiempo{
    var hora = pedirValorInt("Introduce la hora >> ")
    var minuto = pedirValorInt("Introduce el minuto (ENTER para omitir) >> ")
    var segundo = pedirValorInt("Introduce el segundo (ENTER para omitir) >> ")
    val lista = obtenerOperacion(hora, minuto, segundo)
    hora = lista[0]; minuto = lista[1]; segundo = lista[2]

    return Tiempo(hora, minuto, segundo)
}


fun main(){
    val time = obtenerTiempo()
    println(time)
    time.incrementar(Tiempo(1,65,125))
    println(time)
    time.decrementar(Tiempo(3,7,2))
    println(time)
}