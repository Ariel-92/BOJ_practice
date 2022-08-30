fun main(args : Array<String>) {
    val (first, second) = readln().split(" ").map { it.toInt() }
    val firstDivisor : ArrayList<Int> = arrayListOf()
    val secondDivisor : ArrayList<Int> = arrayListOf()
    var gcd : Int = 1
    var cm : Int = 1

    if(first == 1 || second == 1){
        println(1)
        println(maxOf(first, second))
    } else {
        var tempNum = first
        for(i in 2..first){
            if(tempNum == 1)
                break
            while(tempNum % i == 0){
                firstDivisor.add(i)
                tempNum /= i
            }
        }
        tempNum = second
        for(i in 2..second){
            if(tempNum == 1)
                break
            while(tempNum % i == 0){
                secondDivisor.add(i)
                tempNum /= i
            }
        }
        var secondIdx = 0
        for(i in 0 until firstDivisor.size){
            if(secondIdx == secondDivisor.size){
                cm *= firstDivisor[i]
            } else if(firstDivisor[i] == secondDivisor[secondIdx]){
                gcd *= firstDivisor[i]
                cm *= firstDivisor[i]
                secondIdx++
            } else if(firstDivisor[i] < secondDivisor[secondIdx]){
                cm *= firstDivisor[i]
            } else{
                while(firstDivisor[i] > secondDivisor[secondIdx]){
                    cm *= secondDivisor[secondIdx]
                    secondIdx++
                    if(secondIdx == secondDivisor.size)
                        break
                }
                if(secondIdx == secondDivisor.size){
                    cm *= firstDivisor[i]
                } else if(firstDivisor[i] == secondDivisor[secondIdx]){
                    gcd *= firstDivisor[i]
                    cm *= firstDivisor[i]
                    secondIdx++
                } else if(firstDivisor[i] < secondDivisor[secondIdx]) {
                    cm *= firstDivisor[i]
                }
            }
        }
        while(secondIdx < secondDivisor.size){
            cm *= secondDivisor[secondIdx]
            secondIdx++
        }
        println(gcd)
        println(cm)
    }
}