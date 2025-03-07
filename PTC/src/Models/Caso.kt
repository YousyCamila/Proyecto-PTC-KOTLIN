package Models
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.MongoTemplate

@Document
data class Caso(
    @Id val id: String? = null,
    val nombreCaso: String,
    val idCliente: String,
    val idDetective: String,
    val evidencias: List<Evidencia> = emptyList(),
    val registroCasos: List<RegistroCaso> = emptyList(),
    val contratos: List<Contrato> = emptyList(),
    val activo: Boolean = true
)