
import Evidencia.EvidenciaMenu
import Casos.MenuDeCasos
import java.util.*

fun main() {

    val evidenciaMenu = EvidenciaMenu()

    // Menú principal para elegir entre las funcionalidades
    println("=== Menú Principal ===")
    println("1. Gestionar Casos")
    println("2. Gestionar Evidencias")
    println("3. Salir")
    print("Seleccione una opción: ")

    when (readln().trim()) {
        "1" -> {
            // Llamar al menú de casos
            MenuDeCasos()
        }
        "2" -> {
            // Llamar al CRUD de evidencias
            val evidenciaCRUD = EvidenciaCRUD()
            evidenciaCRUD.iniciar()
        }
        "3" -> {
            println("Saliendo del sistema...")
        }
        else -> {
            println("Opción inválida. Intente de nuevo.")
        }
    }
    val scanner = Scanner(System.`in`)
    val evidenciaCRUD = EvidenciaCRUD()

    while (true) {
        println("\n=== Menú Principal ===")
        println("1. Gestionar Casos")
        println("2. Gestionar Evidencias")
        println("3. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> evidenciaMenu.gestionarCasos()
            2 -> evidenciaCRUD.iniciar()
            3 -> {
                println("Saliendo del sistema...")
                return
            }
            else -> println("Opción inválida, intente de nuevo.")
        }
    }
}