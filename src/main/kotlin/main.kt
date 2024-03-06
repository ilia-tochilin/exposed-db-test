import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


fun main() {
    val database = Database.connect(
        url = "jdbc:postgresql://localhost:5432/postgres",
        user = "postgres",
        password = "admin",

    )
    println("database.version = ${database.version}")


    transaction {
        val newId = Person.insert {
            it[id] = 1
            it[name] = "ilia"
            it[age] = 23
        } get Person.id
        println("newId = $newId")
    }
    check()
}


fun check() {
    val allPeople = transaction {
        Person.selectAll().map {
            PersonDTO(
                it[Person.id],
                it[Person.name],
                it[Person.age],
            )
        }
    }
    allPeople.forEach { println(it) }
}


data class PersonDTO(
    val id: Int,
    val name: String,
    val age: Int,
)

object Person : Table() {
    val id = integer("id")
    val name = varchar("name", 128)
    val age = integer("age")

    override val primaryKey = PrimaryKey(id)
}
