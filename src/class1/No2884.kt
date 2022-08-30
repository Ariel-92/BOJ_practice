fun main(args: Array<String>){
    val input : String = readln()
    val temp = input.split(" ")
    var hour = temp[0].toInt()
    var minute = temp[1].toInt()

    minute -= 45
    if(minute < 0){
        minute += 60
        hour--
    }
    if(hour < 0)
        hour = 23

    println("$hour $minute")
}