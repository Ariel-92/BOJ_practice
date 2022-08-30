fun main(args: Array<String>){
    var first : Int = readLine()!!.toInt()
    var second : Int = readLine()!!.toInt()
    var third : Int = readLine()!!.toInt()

    var mul : Int = first * second * third
    var strMul : String = mul.toString()
    val count : MutableMap<String, Int> = mutableMapOf()

    for(i: Int in 0..9){
        count.put(i.toString(), 0)
    }
    for(num in strMul) {
        count[num.toString()] = count[num.toString()]!!.plus(1)
    }
    for(i: Int in 0..9){
        println(count[i.toString()])
    }
}