import Detective.TipoEvidencia

class Evidencia(
    private var descripcion: String,
    private var fecha: String,
    private var tipo: TipoEvidencia
) {
    override fun toString(): String {
        return "Fecha: $fecha - Tipo: $tipo - Descripción: $descripcion"
    }
}
