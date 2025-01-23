import obtenerOperacion

fun obtenerTiempo(): Tiempo{
    var hora = pedirValorInt("Introduce la hora >> ")
    var minuto = pedirValorInt("Introduce el minuto (ENTER para omitir) >> ")
    var segundo = pedirValorInt("Introduce el segundo (ENTER para omitir) >> ")

    return Tiempo(hora, minuto, segundo)
}


fun main(){
    val time = obtenerTiempo()
    println(time)
    
    if (time.incrementar(obtenerTiempo())) {
        print("Tiempo incrementado: ")
        println(time)
    } else print("ERROR al incrementar: ")
    if (time.decrementar(obtenerTiempo())) {
        println("Tiempo decrementado: ")
        println(time)
    } else println("ERROR al decrementar")

    println("Resultado al comparar: ${time.comparar(obtenerTiempo())}")

    println("Tiempo copiado del objeto: ${time.copiar()}")

    println("Tiempo copiado al objeto: ${time.copiar(obtenerTiempo())}")

    println("Resultado de la suma: ${time.sumar(obtenerTiempo())}")
    println("Resultado de la resta: ${time.restar(obtenerTiempo())}")

    println("¿Es mayor? ${time.esMayorQue(obtenerTiempo())}")
    println("¿Es menor? ${time.esMenorQue(obtenerTiempo())}")


}