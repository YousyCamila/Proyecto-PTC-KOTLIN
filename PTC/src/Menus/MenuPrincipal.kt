import Administrador.Clientes.CRUD
import Administrador.Contrato

class MenuPrincipal {
    private val crudClientes = CRUD()
    private val contrato = Contrato()

    fun mostrarMenu() {
        while (true) {
            println("\n===== MENÚ PRINCIPAL =====")
            println("1. Gestión de Clientes")
            println("2. Gestión de Contratos")
            println("3. Salir")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> menuClientes()
                "2" -> menuContratos()
                "3" -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida. Intente de nuevo.")
            }
        }
    }

    private fun menuClientes() {
        while (true) {
            println("\n--- Gestión de Clientes ---")
            println("1. Agregar Cliente")
            println("2. Editar Cliente")
            println("3. Eliminar Cliente")
            println("4. Mostrar Clientes")
            println("5. Volver al Menú Principal")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> crudClientes.crear()
                "2" -> crudClientes.editar()
                "3" -> crudClientes.eliminar()
                "4" -> crudClientes.mostrarClientes()
                "5" -> return
                else -> println("Opción inválida. Intente de nuevo.")
            }
        }
    }

    private fun menuContratos() {
        while (true) {
            println("\n--- Gestión de Contratos ---")
            println("1. Agregar Contrato")
            println("2. Volver al Menú Principal")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> contrato.agregarContrato()
                "2" -> return
                else -> println("Opción inválida. Intente de nuevo.")
            }
        }
    }
}
