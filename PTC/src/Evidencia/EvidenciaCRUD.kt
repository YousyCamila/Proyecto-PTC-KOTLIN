import java.util.Scanner
import Evidencia.Evidencia
import Evidencia.TipoEvidencia

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
            println("5. Buscar Evidencias por ID de Caso")
            println("6. Salir")
            print("Seleccione una opción: ")

            when (scanner.nextInt()) {
                1 -> agregarEvidencia()
                2 -> editarEvidencia()
                3 -> eliminarEvidencia()
                4 -> mostrarEvidencias()
                5 -> buscarEvidenciasPorCaso()
                6 -> {
                    println("Saliendo...")
                    break
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }

    private fun agregarEvidencia() {
        scanner.nextLine() // Consumir el salto de línea que queda después de nextInt()

        print("Ingrese el ID del caso relacionado: ")
        val idCaso = scanner.nextLine()
        if (idCaso.isBlank()) {
            println("Error: El ID del caso es obligatorio.")
            return
        }

        print("Ingrese el ID de la evidencia: ")
        val id = scanner.nextLine()
        if (id.isBlank()) {
            println("Error: El ID de la evidencia es obligatorio.")
            return
        }

        print("Ingrese la descripción: ")
        val descripcion = scanner.nextLine()
        if (descripcion.isBlank()) {
            println("Error: La descripción es obligatoria.")
            return
        }

        print("Ingrese la fecha (YYYY-MM-DD): ")
        val fecha = scanner.nextLine()
        if (fecha.isBlank()) {
            println("Error: La fecha es obligatoria.")
            return
        }

        val tipo = seleccionarTipoEvidencia()

        evidencias.add(Evidencia(id, descripcion, fecha, tipo, idCaso))
        println("Evidencia agregada exitosamente.")
    }

    private fun editarEvidencia() {
        mostrarEvidencias()
        if (evidencias.isEmpty()) return

        print("Seleccione el índice de la evidencia a editar: ")
        val indice = scanner.nextInt()
        scanner.nextLine() // Consumir el salto de línea

        if (indice in evidencias.indices) {
            print("Nuevo ID: ")
            val nuevoId = scanner.nextLine()
            if (nuevoId.isBlank()) {
                println("Error: El ID de la evidencia es obligatorio.")
                return
            }

            print("Nueva descripción: ")
            val nuevaDescripcion = scanner.nextLine()
            if (nuevaDescripcion.isBlank()) {
                println("Error: La descripción es obligatoria.")
                return
            }

            print("Nueva fecha (YYYY-MM-DD): ")
            val nuevaFecha = scanner.nextLine()
            if (nuevaFecha.isBlank()) {
                println("Error: La fecha es obligatoria.")
                return
            }

            val nuevoTipo = seleccionarTipoEvidencia()
            print("Nuevo ID del caso relacionado: ")
            val nuevoIdCaso = scanner.nextLine()
            if (nuevoIdCaso.isBlank()) {
                println("Error: El ID del caso es obligatorio.")
                return
            }

            evidencias[indice] = Evidencia(nuevoId, nuevaDescripcion, nuevaFecha, nuevoTipo, nuevoIdCaso)
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
        scanner.nextLine() // Consumir el salto de línea

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

    private fun buscarEvidenciasPorCaso() {
        scanner.nextLine() // Consumir el salto de línea
        print("Ingrese el ID del caso: ")
        val idCaso = scanner.nextLine()

        val evidenciasFiltradas = evidencias.filter { it.idCaso == idCaso }
        if (evidenciasFiltradas.isEmpty()) {
            println("No se encontraron evidencias para el caso con ID: $idCaso")
        } else {
            println("\n--- Evidencias del Caso $idCaso ---")
            evidenciasFiltradas.forEachIndexed { index, evidencia -> println("$index. $evidencia") }
        }
    }

    private fun seleccionarTipoEvidencia(): TipoEvidencia {
        while (true) {
            println("Seleccione el tipo de evidencia:")
            println("1. Imagen")
            println("2. Video")
            println("3. Documento")
            println("4. Audio")
            print("Opción: ")
            when (scanner.nextInt()) {
                1 -> return TipoEvidencia.IMAGEN
                2 -> return TipoEvidencia.VIDEO
                3 -> return TipoEvidencia.DOCUMENTO
                4 -> return TipoEvidencia.AUDIO
                else -> println("Opción inválida, intente de nuevo.")
            }
        }
    }
}
