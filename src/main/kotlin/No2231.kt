import kotlin.math.pow

fun main(args : Array<String>){
    val strNumber : String = readln()
    var minNum : Int = 10.toDouble().pow(strNumber.length - 1).toInt()
    val number : Int = strNumber.toInt()

    if(number < minNum + (9 * strNumber.length))
        minNum -= 9 * (strNumber.length - 1)

    if(minNum < 1)
        minNum = 1

    var result : Int = 0

    for(min in minNum..number){
        var sum : Int = min
        for(i in 0 until min.toString().length)
            sum += min.toString()[i].digitToInt()
        if(sum == number) {
            result = min
            break
        }
    }

    println(result)
}