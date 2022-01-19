import kotlin.random.Random

interface Dispara{
    val nombre: String
    val municion: Int
    val municionARestar: Int
    val maxMunicion : Int
    var municionActual : Int
    fun dispara(){
        municionActual -= municionARestar
    }
    fun recargar(){
        municionActual = maxMunicion
    }
}


abstract class ArmaDeFuego(override val nombre: String, override val municion: Int, override val municionARestar: Int): Dispara{
    open val tipoDeMunicion : String = ""
    open val radio = ""
    open val danio = 0

    override fun toString(): String {
        return "El arma $nombre tiene $municionActual de $maxMunicion $tipoDeMunicion"
    }

    class Pistola(override val nombre: String, override var municion: Int, override val municionARestar: Int): ArmaDeFuego(nombre, municion, municionARestar){
        override val tipoDeMunicion = "balas"
        override val radio = "Pequeño"
        override val danio = 35
        override var municionActual = municion
        override val maxMunicion = municion
        override fun dispara(){
            if (municionActual >= municionARestar) {
                municionActual -= municionARestar
            }else
                mensajeRecarga()
        }
    }
    class Rifle(override val nombre: String, override var municion: Int, override val municionARestar: Int): ArmaDeFuego(nombre, municion, municionARestar){
        override val tipoDeMunicion = "balas"
        override val radio: String = "Pequeño"
        override val danio = 70
        override var municionActual = municion
        override val maxMunicion = municion
        override fun dispara(){
            if (municionActual >= municionARestar * 2) {
                municionActual -= municionARestar * 2
            }else
                mensajeRecarga()
        }
    }
    class Bazooka(override val nombre: String, override var municion: Int, override val municionARestar: Int): ArmaDeFuego(nombre, municion, municionARestar){
        override val tipoDeMunicion = "cohetes"
        override val radio: String = "Amplio"
        override val danio = 110
        override var municionActual = municion
        override val maxMunicion = municion
        override fun dispara(){
            if (municionActual >= municionARestar * 3) {
                municionActual -= municionARestar * 3
            }else
                mensajeRecarga()
        }
    }
}

class Gato(override val nombre: String, override var municion: Int, override val municionARestar: Int): Dispara{
    private val tipoDeMunicion = "bolas de pelo"
    val radio: String = "Pequeño"
    val danio = 20
    override var municionActual = municion
    override val maxMunicion = municion
    override fun dispara(){
        if (municionActual >= municionARestar) {
            municionActual -= municionARestar
        }else
            mensajeRecarga()
    }
    override fun toString(): String {
        return "El arma $nombre tiene $municionActual de $maxMunicion $tipoDeMunicion"
    }
}

class Movil(override val nombre: String, override var municion: Int, override val municionARestar: Int): Dispara{
    private val tipoDeMunicion = "rayos"
    val radio: String = "Amplio"
    val danio = 50
    override var municionActual = municion
    override val maxMunicion = municion
    override fun dispara(){
        if (municionActual >= municionARestar * 2) {
            municionActual -= municionARestar * 2
        }else
            mensajeRecarga()
    }
    override fun toString(): String {
        return "El arma $nombre tiene $municionActual de $maxMunicion $tipoDeMunicion"
    }
}

class Boli(override val nombre: String, override var municion: Int, override val municionARestar: Int): Dispara{
    private val tipoDeMunicion = "balas de tinta"
    val radio: String = "Pequeño"
    val danio = 35
    override var municionActual = municion
    override val maxMunicion = municion
    override fun dispara(){
        if (municionActual >= municionARestar) {
            municionActual -= municionARestar
        }else
            mensajeRecarga()
    }
    override fun toString(): String {
        return "El arma $nombre tiene $municionActual de $maxMunicion $tipoDeMunicion"
    }
}

fun main() {
    val arma1 = ArmaDeFuego.Pistola("pistola de caza", 20, 1)
    val arma2 = ArmaDeFuego.Rifle("rifle de asalto", 60, 1)
    val arma3 = ArmaDeFuego.Bazooka("bazooka", 10, 1)
    val arma4 = Gato("Michi",40,1)
    val arma5 = Movil("Xiaomi",30,1)
    val arma6 = Boli("Bic",60,1)
    val mapaArmas = arrayListOf(arma1,arma2,arma3,arma4,arma5,arma6)
    val mapaDisparos = mapOf("D1" to armaAleatoria(mapaArmas),"D2" to armaAleatoria(mapaArmas),"D3" to armaAleatoria(mapaArmas),"D4" to armaAleatoria(mapaArmas),"D5" to armaAleatoria(mapaArmas),"D6" to armaAleatoria(mapaArmas))

    mapaDisparos.forEach {
        it.value.dispara()
        println("Has disparado el arma ${it.value.nombre}. ${it.value}")
    }

}
fun armaAleatoria(listaArmas: ArrayList<Dispara>): Dispara {
    val indice = Random.nextInt(0,6)
    return listaArmas[indice]
}
fun mensajeRecarga() {
    println("No tiene suficientes balas, recarga")
}

/*
Preguntas de teoría

b. Al usar una clase abstracta diferencias las clases que instancias posteriormente y cuáles son clases intermedias.
Al usar una interfaz generas un molde que posteriormente utilizaras para implementar en las clases.

c. He utilizado el modificador abstract para forzar la herencia en la clase ArmaDeFuego

 */