class Tiempo(var hora: Int, var minuto: Int, var segundo: Int) {

    constructor(hora: Int, minuto: Int): this(hora, minuto, 0)
    constructor(hora: Int): this(hora, 0, 0)

    fun incrementar(t: Tiempo): Boolean{
        val lista = obtenerOperacion(t.hora+hora, t.minuto+minuto, t.segundo+segundo)
        return if (lista[0] > 24) false else {
            hora = lista[0]; minuto = lista[1]; segundo= lista[2]
            true
        }

    }

    fun decrementar(t: Tiempo): Boolean{
        var h = hora; var m = minuto; var s = segundo
        if (h < 0) return false
        while(s-t.segundo < 0) {
            m--
            s = 60 + (s - t.segundo)

            while (m - t.minuto < 0) {
                h--
                m = 60 + (m - t.minuto)
            }
        }

        while(m-t.minuto < 0){
            h--
            m = 60 + (m-t.minuto)
        }

        if(h < 0) return false else {
            hora = h; minuto = m; segundo = s
            return true
        }
    }
    /*fun decrementar(t: Tiempo): Boolean{
        var h = t.hora; var m = t.minuto; var s = t.segundo
        hora-=h
        if (hora < 0) return false
        while(segundo-s < 0) {
            minuto--
            segundo = 60 + (segundo - s)

            while (minuto - m < 0) {
                hora--
                minuto = 60 + (minuto - m)
            }
        }

        while(minuto-m < 0){
            hora--
            minuto = 60 + (minuto-m)
        }

        if(hora < 0) return false else return true
    }*/



    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }
}

