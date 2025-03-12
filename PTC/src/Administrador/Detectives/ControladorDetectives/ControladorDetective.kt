package Administrador.Detectives.ControladorDetectives
import Administrador.Detectives.ModelsDetectives.Detectives
import Persona.Persona
import java.io.IO.*

class ControladorDetective : FunAdministrador() {

    override fun crear() {

        print("Ingrese el id del detective: ")
        val idDetective = readln()

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

        val nuevoDetective = Detectives(Persona(idDetective, nomDetective, celDetective, direccDetective, correoDetective))
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
        println("1. Id")
        println("2. Nombre")
        println("3. Celular")
        println("4. Dirección")
        println("5. Correo")
        print("Seleccione el campo a editar: ")

        when (readln()) {
            "1" -> {
                print("Ingrese el id ")
                detectiveSeleccionado.persona.id = readln()
            }
            "2" -> {
                print("Ingrese el nuevo nombre: ")
                detectiveSeleccionado.persona.nombre = readln()
            }
            "3" -> {
                print("Ingrese el nuevo celular: ")
                detectiveSeleccionado.persona.celular = readln().toIntOrNull() ?: return println("Número inválido.")
            }
            "4" -> {
                print("Ingrese la nueva dirección: ")
                detectiveSeleccionado.persona.direccion = readln()
            }
            "5" -> {
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
                println("${index + 1}. ${detective.persona.id} - ${detective.persona.nombre} - ${detective.persona.celular} - ${detective.persona.direccion} - ${detective.persona.correo}")
            }
        }
    }
}
