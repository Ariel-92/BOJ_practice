fun main() {
    val result : StringBuilder = java.lang.StringBuilder("")

    while(true){
        val (first, second, third) = readln().split(" ").map { it.toLong() * it.toLong() }
        if(first == 0.toLong() && second == 0.toLong() && third == 0.toLong())
            break

        if(third == first + second || second == first + third || first == second + third)
            result.append("right\n")
        else
            result.append("wrong\n")
    }

    println(result)
}