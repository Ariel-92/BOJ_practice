fun main() {
    val (A, B, V) = readln().split(" ").map { it.toInt() }
    var result = ((V - A) / (A - B)) + 1
    if(((V - A) % (A - B)) > 0)
        result++

    println(result)
}