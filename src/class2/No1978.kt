package CLASS2

fun main(args: Array<String>){
    readln()
    var numbers = readln().split(" ")
    val decimals = BooleanArray(1001)

    decimals[1] = true
    for(i in 2..499){
        if(!decimals[i]){
            var temp = i + i
            while(temp <= 1000){
                decimals[temp] = true
                temp += i
            }
        }
    }

    var count = 0
    for(num in numbers){
        if(!decimals[num.toInt()])
            count++
    }

    println(count)
}