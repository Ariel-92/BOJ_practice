fun main(args: Array<String>){
    var answer : HashSet<Int> = HashSet()

    for(i in 1..10){
        var num = readln().toInt()
        answer.add(num % 42)
    }

    println(answer.size)
}