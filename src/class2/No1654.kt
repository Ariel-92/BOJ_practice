package CLASS2

fun main(args: Array<String>){
    var str = readln().split(" ")
    var numCount = str[0].toInt()
    var minCount = str[1].toLong()
    val numbers = arrayListOf<Long>()

    var sum = 0.toLong()
    var max : Long = 0
    var minNum : Long = Long.MAX_VALUE
    for(i in 0 until numCount){
        numbers.add(readln().toLong())
        sum += numbers[i]
        if(max < numbers[i])
            max = numbers[i]
        if(minNum > numbers[i])
            minNum = numbers[i]
    }

    var temp = (max + minNum) / 2
    if(temp < 0)
        temp = 1
    var preNum = temp
    var min = 0.toLong()

    if(sum in 1 until minCount){
        println(0)
        return
    }

    while(true){
        if(minCount == 1.toLong()){
            println(max)
            break
        }
        var tempCount : Long = 0
        for(num in numbers){
            tempCount += num / temp
        }
        if(tempCount < 0)
            tempCount = Long.MAX_VALUE
        if(tempCount >= minCount) {
            preNum = temp
            min = temp
            temp += (max - temp + 1) / 2
        }
        else{
            max = temp
            temp -= (temp - min) / 2
        }
        if(temp == max){
            println(preNum)
            break
        }
    }
}