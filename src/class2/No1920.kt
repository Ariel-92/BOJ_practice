package CLASS2

fun main(args : Array<String>){
    var aCount : Int = readln().toInt()
    var aStr = readln()
    var a = aStr.split(" ")

    var mCount : Int = readln().toInt()
    var mStr = readln()
    var m = mStr.split(" ")

    var aSorted = a.sorted()

    for(num in m){
        var min = 0
        var max = aCount
        var current = aCount / 2
        while(true){
            if(current < 0 || current >= aCount){
                println("0")
                break
            }
            if(aSorted[current] == num){
                println("1")
                break
            }else if(aSorted[current] < num){
                if(current == max || current == min){
                    println("0")
                    break
                }
                min = current
                current += (max - current + 1) / 2
            }else{
                if(current == max || current == min){
                    println("0")
                    break
                }
                max = current
                current = (current - min) / 2
            }
        }
    }
}