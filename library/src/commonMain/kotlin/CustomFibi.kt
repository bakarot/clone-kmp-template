object CustomFibi {
    fun helloWorld(): String {
        return "Hello, World!"

    }
}

val fibi = sequence {
    var a = firstElement
    yield(a)
    var b = secondElement
    yield(b)
    while (true) {
        val c = a + b
        yield(c)
        a = b
        b = c
    }
}

expect val firstElement: Int
expect val secondElement: Int
