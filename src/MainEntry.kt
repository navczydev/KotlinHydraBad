typealias p = Person

/**
 * @author Nav Singh
 */
fun main() {
    println("Welcome to MeetUp")

    val person0 by lazy {
        p("P", 0, null)
    }

    //class with constructor parameter
    val person = Person("KT", 26, null)
    val person2 = Person("KT", 26, "Kotlin")
    val person3 = Person("KT", 26, "Swift")


    //apply
    val personSecondVersion1 = PersonSecondVersion().apply {
        name ="sfsd"
        hobby ="codong"
        age = 12
    }


    //first or firstNull
    val listOfPersons = listOf(person, person2, person3)
    listOfPersons.firstOrNull { it.hobby == "Java" }

    //single or singleNull
    val listOfPersons1 = listOf(person2, person3)
    listOfPersons.singleOrNull { it.hobby == "Java" }

    //string toLower/equals
    val str1 = "KOTLIN"
    val str2 = "Kotlin"
    //println(str1.toLowerCase() == str2.toLowerCase())
    println(str1.equals(str2, ignoreCase = true))

    //platform based types
    val javaPerson = JavaPerson()
    javaPerson.name = "Roy"
    javaPerson.name?.let {
        println(it.length)
    }
    //listOf(javaPerson).stream().


    //java not null check let
    if (javaPerson.name != null) {
        //!!
        //?
        //do something
    }

    //javaPerson.name!!.


    //swapping kotlin way
    var a = 5
    var b = 10
    a = b.also {
        b = a
    }

    println("a is $a")
    println("b is $b")

    //with
    val p = PersonSecondVersion()


    with(p){
        nameLength()
        getDoubledAge()
        checkAddressInit()
    }

    infix fun Int.add(x: Int): Int {
        return this.plus(x)
    }

    // + , - , plus, minus
    var n = 5
    //new variable
    n.plus(5)
    n += 5
    println(n)
    println("Infix operator:  ${n add 5}")

    //list add, minus
    val listOfP = arrayListOf(person)
    // new list
    val i = listOfP + person
    println(i)

    whenOverIf()

    inUse()

    println(whenAsExp(5))

    //?:
    var nullableString: String? = null
    println("Nullable ${nullableString ?: "I am null"}")

    mapWithDefault()

    println(stringIfBlank("abc"))

    //null to notNullabeList
    notNullableList()

    streamVsSequence()

    deStructuring()

    regexWithRawStrings()

    listUnionIntersectSubtract()

    forLoops()

}

fun notNullableList() {
    //class with constructor parameter
    val person = Person("KT", 26, null)
    val person1: Person? = null
    val person2 = Person("KT", 26, "xyz")
    val person3 = Person("KT", 26, "xyz")
    //var list = arrayListOf<Person>()
    if (person1 != null) {
        //add to the list
       // list.add(person1)
    }
    println(listOfNotNull(person,person1,person2,person3))
    //filterNotNull
}

fun stringIfBlank(s: String): String {
    //return if (s.isBlank()) "" else s
    return s.ifBlank { "ok" }
    //return s.ifEmpty { "not found" }
}

fun mapWithDefault(): Map<Int, String> {
    return mapOf(
        1 to "1",
        2 to "2"
    ).withDefault {
        "?"  //only work with get, index access still throws error
    }
}

fun whenAsExp(a: Int) = when {
    a > 15 -> {
        "ok"
    }

    else -> "np"
}

fun whenOverIf() {
    val n = 15
    val m = 10
    when {
        n > m -> {
            // do
        }
        n < m -> {
            //do stuff here
        }
        else -> {
            //default
        }
    }
}

fun inUse() {
    val n = 20
    if (n in 0..25) {
        //do stuff
    }

    val str1 = "Kotlin"
    val str2 = "Java"
    val str3 = "Swift"
    if (str1 !in listOf(str2,str3)) {

    }
}

//extension func
fun Int.bool(): Boolean = this == 1


fun streamVsSequence() {
    val person = Person("KT", 18, null)
    val person1: Person? = null
    val person2 = Person("KT", 26, "xyz")
    val person3 = Person("KT", 26, "xyz")
    val list = listOf(
        person, person2, person3

    )

    list.asSequence().filter {
        println("filtering")
        it.age > 25
    }.map {
        println("mapping")
        it.name
    }.first()
}

//destructuring
fun deStructuring() {
    val dataClassExample = DataClassExample(5,  "nav",10)
    val (age, phoneNum) = dataClassExample
    println("Age is $age - PhoneNum is $phoneNum")

}

fun regexWithRawStrings() {
    //val regexOldWay = "(\\d){2}-(\\d){2}-(\\d){4}".toRegex()
    val regex = """(\d){2}-(\d){2}-(\d){4}""".toRegex()
    println(regex.matches("20-10-2018"))
    val(day, month, year) = regex.find("20-10-2018")!!.destructured
}

fun listUnionIntersectSubtract() {
    val p = Person("KT", 21, null)
    val p1: Person? = null
    val p2 = Person("KT", 26, "xyz")
    val p3 = Person("KT", 26, "xyz")
    val p4 = Person("Kotlin", 24, "xyz")
    val list = listOf(
        p, p2, p3

    )
    val list1 = listOf(
        p, p3, p4

    )

    println("Union: ${list.union(list1)}")
    println("Intersection: ${list.intersect(list1)}")
    println("Subtract: ${list.subtract(list1)}")
}

fun forLoops() {
    val p = Person("KT", 21, "kotlin coding")
    val p2 = Person("KT", 21, "xyz")
    val p3 = Person("KT", 20, "xyz")
    val p4 = Person("Kotlin", 21, "xyz")
    val list = listOf(
        p, p2, p3, p4

    )


    for (i in list.indices) {

    }

    //kotlin
    for (i in list.indices) {


    }

    list.forEachIndexed { index, person ->

    }

    //for with lambda receiver
    list.forEachIndexed(personWithIndex)

    println("/.svsvgg".removePrefix("/."))
    println("/.svsvgg".removeSuffix("/."))
    println("/.svsvgg/.".removeSurrounding("/."))
    "CVDBD".takeIf { it.length > 15 }?.run {
        println(this)
    }?: run {
        //if null
    }
}

