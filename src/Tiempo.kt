class Tiempo(val hora: Int, val minuto: Int, val segundo: Int) {

    constructor(hora: Int, minuto: Int): this(hora, minuto, 0)
    constructor(hora: Int): this(hora, 0, 0)



    override fun toString(): String {
        return "${hora}h ${minuto}m ${segundo}s"
    }
}

