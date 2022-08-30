fun main(args: Array<String>){
    val input = readln()
    val temp = input.split(" ")

    var first : String = ""
    var second : String = ""

    for(i in temp[0])
        first = i.toString() + first

    for(i in temp[1])
        second = i.toString() + second

    if(first.toInt() > second.toInt())
        println(first)
    else
        println(second)
}