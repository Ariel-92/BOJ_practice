fun main(args : Array<String>){
    val str = readln()
    val numbers = str.split(" ")
    println(numbers[0].toInt() * numbers[1].toInt())
}