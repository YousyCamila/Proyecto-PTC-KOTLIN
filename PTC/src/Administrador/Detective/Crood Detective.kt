package Administrador.Detectives

import Administrador.FunAdministrador
import Persona.Persona

class Crood etective : FunAdministrador() {

    override fun crear() {
        print("Ingrese el nombre del detective: ")
        val nomDetective = readln()

        println("Ingrese el número de celular: ")
        val celDetective = readln().toIntOrNull() ?: run {
            println("Número inválido. Intente de nuevo.")
            return
        }

        print("Ingrese la dirección: ")
        val direccDetective = readln()

        print("Ingrese el correo: ")
        val correoDetective = readln()

        val nuevoDetective = Detective(Persona(nomDetective, celDetective, direccDetective, correoDetective))
        Detectives.listaDetectives.add(nuevoDetective)

        println("Detective agregado exitosamente.")
    }

    override fun editar() {
        if (Detectives.listaDetectives.isEmpty()) {
            println("No hay detectives para editar.")
            return
        }

        println("Seleccione el detective a editar:")
        Detectives.listaDetectives.forEachIndexed { index, detective ->
            println("${index + 1}. ${detective.persona.nombre}")
        }

        val seleccion = readln().toIntOrNull()
        if (seleccion == null || seleccion !in 1..Detectives.listaDetectives.size) {
            println("Selección inválida.")
            return
        }

        val detectiveSeleccionado = Detectives.listaDetectives[seleccion - 1]
        println("Editando detective: ${detectiveSeleccionado.persona.nombre}")

        println("1. Nombre")
        println("2. Celular")
        println("3. Dirección")
        println("4. Correo")
        print("Seleccione el campo a editar: ")

        when (readln()) {
            "1" -> {
                print("Ingrese el nuevo nombre: ")
                detectiveSeleccionado.persona.nombre = readln()
            }
            "2" -> {
                print("Ingrese el nuevo celular: ")
                detectiveSeleccionado.persona.celular = readln().toIntOrNull() ?: return println("Número inválido.")
            }
            "3" -> {
                print("Ingrese la nueva dirección: ")
                detectiveSeleccionado.persona.direccion = readln()
            }
            "4" -> {
                print("Ingrese el nuevo correo: ")
                detectiveSeleccionado.persona.correo = readln()
            }
            else -> println("Opción inválida.")
        }

        println("Detective actualizado correctamente.")
    }

    override fun eliminar() {
        if (Detectives.listaDetectives.isEmpty()) {
            println("No hay detectives para eliminar.")
            return
        }

        println("Seleccione el detective a eliminar:")
        Detectives.listaDetectives.forEachIndexed { index, detective ->
            println("${index + 1}. ${detective.persona.nombre}")
        }

        val seleccion = readln().toIntOrNull()
        if (seleccion == null || seleccion !in 1..Detectives.listaDetectives.size) {
            println("Selección inválida.")
            return
        }

        val detectiveSeleccionado = Detectives.listaDetectives[seleccion - 1]
        println("¿Está seguro de eliminar a ${detectiveSeleccionado.persona.nombre}? (1: Sí, 2: No)")

        when (readln()) {
            "1" -> {
                Detectives.listaDetectives.removeAt(seleccion - 1)
                println("Detective eliminado exitosamente.")
            }
            "2" -> println("Operación cancelada.")
            else -> println("Opción inválida.")
        }
    }

    fun mostrarDetectives() {
        if (Detectives.listaDetectives.isEmpty()) {
            println("No hay detectives registrados.")
        } else {
            println("\n=== Lista de Detectives ===")
            Detectives.listaDetectives.forEachIndexed { index, detective ->
                println("${index + 1}. ${detective.persona.nombre} - ${detective.persona.celular} - ${detective.persona.direccion} - ${detective.persona.correo}")
            }
        }
    }
}
