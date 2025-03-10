package Administrador.Detectives
import Administrador.Detectives.CroodDetective

class DetectiveMenu {
    fun MenuDeDetectives(){
        val crudDetective = CroodDetective()

        while (true) {
            println("\n--- Menú de Gestión de Detectives ---")
            println("1. Agregar Detective")
            println("2. Editar Detective")
            println("3. Eliminar Detective")
            println("4. Mostrar Detectives")
            println("5. Salir")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> crudDetective.crear()
                "2" -> crudDetective.editar()
                "3" -> crudDetective.eliminar()
                "4" -> crudDetective.mostrarDetectives()
                "5" -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}