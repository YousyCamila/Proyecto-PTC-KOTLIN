package Administrador.Clientes.ControladorClientes

import Administrador.Clientes.ClientesDAO.ClientesDAO
import Administrador.Clientes.ModelsCliente.Clientes
import Administrador.Detectives.ControladorDetectives.FunAdministrador
import Persona.Persona

class ControladorCliente {

    private val clientesDAO = ClientesDAO()

    fun mostrarClientes() {
        val clientes = clientesDAO.obtenerTodosLosClientes()
        if (clientes.isEmpty()) {
            println("No hay clientes registrados.")
        } else {
            println("\n=== Lista de Clientes ===")
            clientes.forEachIndexed { index, cliente ->
                println("${index + 1}. ${cliente.persona.id} - ${cliente.persona.nombre} - ${cliente.persona.celular} - ${cliente.persona.direccion} - ${cliente.persona.correo}")
            }
        }
    }

    fun agregarCliente() {
        print("Ingrese el id: ")
        val idCliente = readln()

        print("Ingrese el nombre del cliente: ")
        val nomCliente = readln()

        print("Ingrese el número de celular: ")
        val celCliente = readln().toIntOrNull() ?: run {
            println("Número inválido. Intente de nuevo.")
            return
        }

        print("Ingrese la dirección: ")
        val direccCliente = readln()

        print("Ingrese el correo: ")
        val correoCliente = readln()

        val nuevoCliente = Clientes(Persona(idCliente, nomCliente, celCliente, direccCliente, correoCliente))

        if (clientesDAO.insertarCliente(nuevoCliente)) {
            println("Cliente agregado exitosamente.")
        } else {
            println("Error al agregar el cliente.")
        }
    }

    fun editarCliente() {
        print("Ingrese el ID del cliente a editar: ")
        val idCliente = readln()

        val clientes = clientesDAO.obtenerTodosLosClientes()
        val clienteSeleccionado = clientes.find { it.persona.id == idCliente }

        if (clienteSeleccionado == null) {
            println("Cliente no encontrado.")
            return
        }

        println("Editando cliente: ${clienteSeleccionado.persona.nombre}")

        println("1. Nombre")
        println("2. Celular")
        println("3. Dirección")
        println("4. Correo")
        print("Seleccione el campo a editar: ")

        when (readln()) {
            "1" -> {
                print("Ingrese el nuevo nombre: ")
                clienteSeleccionado.persona.nombre = readln()
            }
            "2" -> {
                print("Ingrese el nuevo celular: ")
                clienteSeleccionado.persona.celular = readln().toIntOrNull() ?: return println("Número inválido.")
            }
            "3" -> {
                print("Ingrese la nueva dirección: ")
                clienteSeleccionado.persona.direccion = readln()
            }
            "4" -> {
                print("Ingrese el nuevo correo: ")
                clienteSeleccionado.persona.correo = readln()
            }
            else -> {
                println("Opción inválida.")
                return
            }
        }

        if (clientesDAO.actualizarCliente(clienteSeleccionado)) {
            println("Cliente actualizado correctamente.")
        } else {
            println("Error al actualizar el cliente.")
        }
    }

    fun eliminarCliente() {
        print("Ingrese el ID del cliente a eliminar: ")
        val idCliente = readln()

        if (clientesDAO.eliminarCliente(idCliente)) {
            println("Cliente eliminado exitosamente.")
        } else {
            println("Error al eliminar el cliente.")
        }
    }
}