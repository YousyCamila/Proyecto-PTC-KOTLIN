package Models

class Detective(
    val id: String,
    val correo: String,
    private val _casos: MutableList<Caso> = mutableListOf()
) {
    val casos: List<Caso> get() = _casos
    fun agregarCaso(caso: Caso) = _casos.add(caso)
}