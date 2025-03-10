package Detective

import Evidencia
import java.util.Scanner

class EvidenciaCRUD {
    private val evidencias = mutableListOf<Evidencia>()
    private val scanner = Scanner(System.`in`)

    fun iniciar() {
        while (true) {
            println("\n--- Gestión de Evidencias ---")
            println("1. Agregar Evidencia")
            println("2. Editar Evidencia")
            println("3. Eliminar Evidencia")
            println("4. Mostrar Evidencias")
            println("5. Salir")
            print("Seleccione una opción: ")

            when (scanner.nextInt()) {
                1 -> agregarEvidencia()
                2 -> editarEvidencia()
                3 -> eliminarEvidencia()
                4 -> mostrarEvidencias()
                5 -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }

    private fun agregarEvidencia() {
        scanner.nextLine()
        print("Ingrese la descripción: ")
        val descripcion = scanner.nextLine()
        print("Ingrese la fecha (YYYY-MM-DD): ")
        val fecha = scanner.nextLine()
        val tipo = seleccionarTipoEvidencia()
        evidencias.add(Evidencia(descripcion, fecha, tipo))
        println("Evidencia agregada exitosamente.")
    }

    private fun editarEvidencia() {
        mostrarEvidencias()
        if (evidencias.isEmpty()) return

        print("Seleccione el índice de la evidencia a editar: ")
        val indice = scanner.nextInt()
        scanner.nextLine()

        if (indice in evidencias.indices) {
            print("Nueva descripción: ")
            val nuevaDescripcion = scanner.nextLine()
            print("Nueva fecha (YYYY-MM-DD): ")
            val nuevaFecha = scanner.nextLine()
            val nuevoTipo = seleccionarTipoEvidencia()
            evidencias[indice] = Evidencia(nuevaDescripcion, nuevaFecha, nuevoTipo)
            println("Evidencia actualizada.")
        } else {
            println("Índice inválido.")
        }
    }

    private fun eliminarEvidencia() {
        mostrarEvidencias()
        if (evidencias.isEmpty()) return

        print("Seleccione el índice de la evidencia a eliminar: ")
        val indice = scanner.nextInt()
        if (indice in evidencias.indices) {
            evidencias.removeAt(indice)
            println("Evidencia eliminada.")
        } else {
            println("Índice inválido.")
        }
    }

    private fun mostrarEvidencias() {
        if (evidencias.isEmpty()) {
            println("No hay evidencias registradas.")
        } else {
            println("\n--- Lista de Evidencias ---")
            evidencias.forEachIndexed { index, evidencia -> println("$index. $evidencia") }
        }
    }

    private fun seleccionarTipoEvidencia(): TipoEvidencia {
        while (true) {
            println("Seleccione el tipo de evidencia:")
            println("1. Imagen")
            println("2. Video")
            print("Opción: ")
            when (scanner.nextInt()) {
                1 -> return TipoEvidencia.IMAGEN
                2 -> return TipoEvidencia.VIDEO
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}

