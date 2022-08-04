fun main(args: Array<String>) {
    val maxCount : Int = readln().toInt()
    val results : ArrayList<Int> = arrayListOf()

    for(i in 0 until maxCount) {
        val (numberMaxCount, checkIdx) = readln().split(" ").map { it.toInt() }
        val numbers : ArrayList<Pair<Int, Int>> = arrayListOf()
        var idx : Int = 0
        readln().split(" ").map {
            numbers.add(Pair(idx, it.toInt()))
            idx++
        }
        val tempPair : Pair<Int, Int> = numbers[checkIdx]
        for(numIdx in 0 until numberMaxCount) {
            while(true) {
                var isMaxPriority : Boolean = true
                for (check in numIdx + 1 until numberMaxCount) {
                    if(numbers[numIdx].second < numbers[check].second) {
                        isMaxPriority = false
                        break
                    }
                }
                if(isMaxPriority)
                    break
                else {
                    val temp : Pair<Int, Int> = numbers[numIdx]
                    numbers.removeAt(numIdx)
                    numbers.add(temp)
                }
            }
        }
        results.add(numbers.indexOf(tempPair) + 1)
    }

    for(result in results)
        println(result)
}