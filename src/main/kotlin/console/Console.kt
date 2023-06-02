package console

@Suppress("unused", "MemberVisibilityCanBePrivate")
object Console {
    fun prompt(message: String, default: String? = null): String {
        print("$message\n> ")
        return readln().ifBlank { default ?: "" }.ifEmpty { default ?: "" }
    }
    fun prompt(): String {
        print("> ")
        return readln()
    }

    fun promptMenu(message: String, options: List<String>): Int {
        println(message)
        for (option in options) {
            println("  ${options.indexOf(option) + 1}. $option")
        }
        return prompt().toInt()
    }
}