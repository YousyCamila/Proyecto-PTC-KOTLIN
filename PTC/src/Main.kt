import Administrador.Clientes.CRUD
import Administrador.Contrato
import Detective.EvidenciaCRUD
import Casos.MenuDeCasos

fun main() {
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
}