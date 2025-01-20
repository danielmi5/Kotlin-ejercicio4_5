fun obtenerTiempo(): Tiempo{
    val hora = pedirValorInt("Introduce la hora >> ")
    val minuto = pedirValorInt("Introduce el minuto (ENTER para omitir) >> ")
    val segundo = pedirValorInt("Introduce el segundo (ENTER para omitir)")
    return Tiempo(hora, minuto, segundo)
}


fun main{
    val time = obtenerTiempo()
    //Hacer comprobar Hora, minuto, segundo, para los rangos 0-23, 0-59, 0-59

}