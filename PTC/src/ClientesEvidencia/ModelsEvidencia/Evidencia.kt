package ClientesEvidencia.ModelsEvidencia

class Evidencia(
    private var id: String,
    private var descripcion: String,
    private var fecha: String,
    private var tipo: TipoEvidencia,
    var idCaso: String
) {
    override fun toString(): String {
        return "ID: $id - Fecha: $fecha - Tipo: $tipo - Descripción: $descripcion - ID Caso: $idCaso"
    }
}