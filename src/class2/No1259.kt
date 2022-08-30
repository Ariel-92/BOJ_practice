package CLASS2

fun main(args : Array<String>){
    val numbers : ArrayList<String> = arrayListOf()
    while(true){
        var str = readln()
        if(str == "0")
            break
        numbers.add(str)
    }

    for(num in numbers){
        var isPalindrome = true
        for(i in 0..num.length / 2){
            if(num[i] != num[num.length - 1 - i]) {
                isPalindrome = false
                break
            }
        }
        if(isPalindrome)
            println("yes")
        else
            println("no")
    }
}
