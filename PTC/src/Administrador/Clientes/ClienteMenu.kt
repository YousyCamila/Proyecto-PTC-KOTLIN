package Administrador.Clientes

class ClienteMenu {
    fun MenuDeCliente(){

        val crud = CRUD()

        while (true) {
            println("\n--- Menú de Gestión de Clientes ---")
            println("1. Agregar Cliente")
            println("2. Editar Cliente")
            println("3. Eliminar Cliente")
            println("4. Mostrar Clientes")
            println("5. Salir")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> crud.crear()
                "2" -> crud.editar()
                "3" -> crud.eliminar()
                "4" -> crud.mostrarClientes()
                "5" -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}