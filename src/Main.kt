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

    println("Introduce un tiempo para incrementar el anterior")
    if (time.incrementar(obtenerTiempo())) {
        print("Tiempo incrementado: ")
        println(time)
    } else print("ERROR al incrementar: ")

    println("Introduce un tiempo para decrementar el anterior")
    if (time.decrementar(obtenerTiempo())) {
        print("Tiempo decrementado: ")
        println(time)
    } else println("ERROR al decrementar")

    println("\nIntroduce un tiempo para comparar con el anterior: ")
    println("Resultado al comparar: ${time.comparar(obtenerTiempo())}")

    println("\nTiempo copiado del objeto: ${time.copiar()}")

    println("\nIntroduce el tiempo a copiar al objeto")
    time.copiar(obtenerTiempo())
    println("Tiempo copiado al objeto: $time")

    println("\nIntroduce un tiempo para sumar: ")
    println("Resultado de la suma: ${time.sumar(obtenerTiempo())}")
    println("\nIntroduce un tiempo para restar: ")
    println("Resultado de la resta: ${time.restar(obtenerTiempo())}")

    println("\nIntroduce un tiempo para comparar: ")
    println("¿Es mayor? ${time.esMayorQue(obtenerTiempo())}")
    println("\nIntroduce otro tiempo para comparar: ")
    println("¿Es menor? ${time.esMenorQue(obtenerTiempo())}")


}