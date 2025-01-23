class Tiempo(var hora: Int, var minuto: Int, var segundo: Int) {

    constructor(hora: Int, minuto: Int): this(hora, minuto, 0)
    constructor(hora: Int): this(hora, 0, 0)

    init{
        require(hora >= 0 || minuto >= 0 || segundo >= 0){"ERROR -> Todos los valores deben ser positivos"}
        // FORMATEO HORAS
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

    }
    fun incrementar(t: Tiempo): Boolean{
        hora += t.hora
        minuto += t.minuto
        segundo += t.segundo

        if (hora > 23) return false else return true
    }

    fun decrementar(t: Tiempo): Boolean{
        var h = hora; var m = minuto; var s = segundo
        h -= t.hora
        if (h < 0) return false
        s -= t.segundo
        m -= t.minuto
        while(s < 0) {
            m--
            s += 60

            while (m < 0) {
                h--
                m += 60
            }
        }


        while(m < 0){
            h--
            m += 60
        }

        if(h < 0) return false else {
            hora = h; minuto = m; segundo = s
            return true
            }
    }


    fun comparar(t:Tiempo):Int{
        when{
            t.hora > hora -> return -1
            t.hora == hora -> {
                when{
                    t.minuto > minuto ->  return -1
                    t.minuto == minuto -> {
                        when{
                           t.segundo > segundo -> return -1
                           t.segundo == segundo -> return 0
                           t.segundo < segundo -> return 1
                        }
                    }
                    t.minuto < minuto -> return 1
                }
            }
            t.hora < hora -> return 1


        }
        return 0
    }

    fun copiar(): Tiempo = Tiempo(hora, minuto, segundo)

    fun copiar(t: Tiempo){
        hora = t.hora
        minuto = t.minuto
        segundo = t.segundo
    }

    fun sumar(t: Tiempo): Tiempo?{
        val time = Tiempo(hora+t.hora, minuto+t.minuto, segundo+t.segundo)
        return if (hora > 23) null else time
    }

    fun restar(t: Tiempo): Tiempo?{
        var h = hora; var m = minuto; var s = segundo
        h -= t.hora
        if (h < 0) return null
        s -= t.segundo
        m -= t.minuto
        while(s < 0) {
            m--
            s += 60

            while (m < 0) {
                h--
                m += 60
            }
        }


        while(m < 0){
            h--
            m += 60
        }

        return if(h < 0) null else Tiempo(h, m, s)
    }


    fun esMayorQue(t: Tiempo): Boolean{
        val resp = this.comparar(t)
        return resp == 1
    }

    fun esMenorQue(t: Tiempo): Boolean{
        val resp = this.comparar(t)
        return resp == -1
    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minuto)}m ${"%02d".format(segundo)}s"
    }
}














/**/







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