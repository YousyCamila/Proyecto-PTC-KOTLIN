package Administrador.Clientes

import Administrador.Clientes.ControladorClientes.ControladorCliente

class ClienteMenu {
    fun MenuDeCliente(){

        val controladorCliente = ControladorCliente()

        while (true) {
            println("\n--- Menú de Gestión de Clientes ---")
            println("1. Agregar Cliente")
            println("2. Editar Cliente")
            println("3. Eliminar Cliente")
            println("4. Mostrar Clientes")
            println("5. Salir")
            print("Seleccione una opción: ")

            when (readln()) {
                "1" -> controladorCliente.agregarCliente()
                "2" -> controladorCliente.editarCliente()
                "3" -> controladorCliente.eliminarCliente()
                "4" -> controladorCliente.mostrarClientes()
                "5" -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}