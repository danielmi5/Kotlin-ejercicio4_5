fun pedirValorInt(msj: String): Int {
    var int: Int = -3
    var salir = false
    do {
        try {
            print(msj)
            var input = readln()
            if ("hora" in msj.lowercase()){
                if (input.isBlank()){
                    println("*ERROR* -> Hora no puede estar vacío.\n")
                } else{
                    int = input.toInt()
                    comprobarRango(int, 0 , 24, true)
                    salir = true
                }
            } else{
                if (input.isBlank()) {
                    int = 0
                    salir = true
                } else {
                    int = input.toInt()
                    //Hacer comprobar Hora, minuto, segundo
                    comprobarRango(int, 0, 59)
                    salir = true
                }
            }
        } catch (e: NumberFormatException){
            println("ERROR -> $e.\n")
        } catch (e: IllegalArgumentException){
            println("ERROR -> $e\n")
        }
    } while (salir == false)
    return int
}

fun obtenerOperacion(hora: Int, minuto: Int, segundo: Int): List<Int>{
    var hora = hora ; var minuto = minuto; var segundo = segundo

    if (segundo > 59) {
        while (segundo > 59) {
            minuto += segundo / 60
            segundo %= 60
            while (minuto > 59) {
                hora += minuto / 60
                minuto %= 60
            }
        }
    } else {
        if (minuto > 59) {
            while (minuto > 59) {
                hora += minuto / 60
                minuto %= 60
            }
        }
    }
    return listOf<Int>(hora, minuto, segundo)
}



fun comprobarRango(valor: Int, min: Int, max: Int, esHora: Boolean = false){
    if (esHora == false){
        if (valor < min) {
            throw IllegalArgumentException("El valor debe ser positivo.")
        }
    } else {
        if (valor !in min..max) {
            throw IllegalArgumentException("El valor debe estar entre $min y $max.")
        }
    }
}