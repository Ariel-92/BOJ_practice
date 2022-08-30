fun main(args: Array<String>){
    val year : Int = readLine()!!.toInt()

    if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        println(1)
    else
        println(0)
}