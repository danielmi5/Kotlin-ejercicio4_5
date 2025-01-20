fun pedirValorInt(msj: String): Int {
    var int: Int = -3
    var salir = false
    do {
        try {
            int = readln()
            if ("hora" in msj.lowercase()){
                if (int.isBlank()){
                    println("*ERROR* -> Hora no puede estar vacío.")
                } else{
                    int = int.toInt()
                    salir = true
                }
            } else{
                if (int.isBlank()) {
                    int = 0
                    salir = true
                } else {
                    int = int.toInt()
                    //Hacer comprobar Hora, minuto, segundo
                    if ("minuto" in msj.lowercase()){

                    } else {

                    }
                    salir = true
                }
            }
        } catch (e: NumberFormatException){
            println("ERROR -> $e.")
        }
    } while (salir == false)
    return int
}