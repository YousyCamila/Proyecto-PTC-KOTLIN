
import Administrador.Clientes.ClienteMenu
import Evidencia.EvidenciaMenu
import Administrador.Detectives.DetectiveMenu
import Casos.MenuDeCasos
import java.util.*

fun main() {

    val evidenciaMenu = EvidenciaMenu()
    val evidenciaCRUD = EvidenciaCRUD()
    val clienteMenu = ClienteMenu()
    val detectiveMenu = DetectiveMenu()

    println("=== Menú Principal ===")
    println("1. Gestionar Casos")
    println("2. Gestionar Evidencias")
    println("3. Gestionar Clientes ")
    println("4. Gestionar Detectives")
    println("5. Salir")
    print("Seleccione una opción: ")

    when (readln().trim()) {
        "1" -> {
            // Llamar al menú de casos
            MenuDeCasos()
        }
        "2" -> {
            // Llamar al CRUD de evidencias

            evidenciaCRUD.iniciar()
        }
        "3" -> {

            clienteMenu.MenuDeCliente()
        }
        "4" ->{
            detectiveMenu.MenuDeDetectives()
        }
        "5" -> {
            println("Saliendo del sistema...")
        }
        else -> {
            println("Opción inválida. Intente de nuevo.")
        }
    }
    val scanner = Scanner(System.`in`)


    while (true) {
        println("\n=== Menú Principal ===")
        println("1. Gestionar Casos")
        println("2. Gestionar Evidencias")
        println("3. Gestionar Clientes")
        println("4. Gestionar Detectives")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> evidenciaMenu.gestionarCasos()
            2 -> evidenciaCRUD.iniciar()
            3 -> clienteMenu.MenuDeCliente()
            4 -> detectiveMenu.MenuDeDetectives()
            5 -> {
                println("Saliendo del sistema...")
                return
            }
            else -> println("Opción inválida, intente de nuevo.")
        }
    }
}