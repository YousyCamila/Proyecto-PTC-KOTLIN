package Administrador.Clientes

import Administrador.FunAdministrador
import Persona.Persona

class CRUD : FunAdministrador() {

    override fun crear() {
        print("Ingrese el id")
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
        Clientes.clientes.add(nuevoCliente)

        println("Cliente agregado exitosamente.")
    }

    override fun editar() {
        if (Clientes.clientes.isEmpty()) {
            println("No hay clientes para editar.")
            return
        }

        println("Seleccione el cliente a editar:")
        Clientes.clientes.forEachIndexed { index, cliente ->
            println("${index + 1}. ${cliente.persona.nombre}")
        }

        val seleccion = readln().toIntOrNull()
        if (seleccion == null || seleccion !in 1..Clientes.clientes.size) {
            println("Selección inválida.")
            return
        }

        val clienteSeleccionado = Clientes.clientes[seleccion - 1]
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
            else -> println("Opción inválida.")
        }

        println("Cliente actualizado correctamente.")
    }

    override fun eliminar() {
        if (Clientes.clientes.isEmpty()) {
            println("No hay clientes para eliminar.")
            return
        }

        println("Seleccione el cliente a eliminar:")
        Clientes.clientes.forEachIndexed { index, cliente ->
            println("${index + 1}. ${cliente.persona.nombre}")
        }

        val seleccion = readln().toIntOrNull()
        if (seleccion == null || seleccion !in 1..Clientes.clientes.size) {
            println("Selección inválida.")
            return
        }

        val clienteSeleccionado = Clientes.clientes[seleccion - 1]
        println("¿Está seguro de eliminar a ${clienteSeleccionado.persona.nombre}? (1: Sí, 2: No)")

        when (readln()) {
            "1" -> {
                Clientes.clientes.removeAt(seleccion - 1)
                println("Cliente eliminado exitosamente.")
            }
            "2" -> println("Operación cancelada.")
            else -> println("Opción inválida.")
        }
    }

    fun mostrarClientes() {
        if (Clientes.clientes.isEmpty()) {
            println("No hay clientes registrados.")
        } else {
            println("\n=== Lista de Clientes ===")
            Clientes.clientes.forEachIndexed { index, cliente ->
                println("${index + 1}. ${cliente.persona.nombre} - ${cliente.persona.celular} - ${cliente.persona.direccion} - ${cliente.persona.correo}")
            }
        }
    }
}