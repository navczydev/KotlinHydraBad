/**
 * @author Nav Singh
 */
class Person(
    var name: String,
    var age: Int,
    var hobby: String?
)

class PersonSecondVersion {
    private lateinit var address: String
    var name: String = ""
    var age: Int = 0
    var hobby: String? = null

    fun checkAddressInit() {
        if (this::address.isInitialized) {
            //do stuff
        }
    }

    fun nameLength(): Int {
        return name.length
    }

    fun getDoubledAge(): Int {
        return age * 2
    }
}

val personWithIndex = { index: Int, person: Person ->
    println("At $index Person name is  ${person.name}")
}
