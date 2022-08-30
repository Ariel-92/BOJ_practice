fun main() {
    /*
        오버플로우 방지를 위해 모든 자료형은 Long으로 통일
    */
    val (treeCount, minLength) = readln().split(" ").map { it.toLong() }
    val trees : MutableMap<Long, Long> = mutableMapOf()
    var maxHeight : Long = 0
    var result : Long = 0

    readln().split(" ").map {
        if(trees.contains(it.toLong())) {
            trees[it.toLong()] = trees[it.toLong()]!!.plus(1)
        }
        else {
            trees[it.toLong()] = 1
            if(it.toLong() > maxHeight)
                maxHeight = it.toLong()
        }
    }

    var lastHeight = maxHeight
    var currentTreeCount : Long = 0
    var temp : Long = 0
    val heights = trees.keys.sortedDescending()

    for(height in heights){
        temp += currentTreeCount * (lastHeight - height)
        if(temp >= minLength) {
            result = height + ((temp - minLength) / currentTreeCount)
            break
        }
        currentTreeCount += trees[height]!!
        lastHeight = height
    }

    if(result == 0.toLong()) {
        temp += currentTreeCount * lastHeight
        result = (temp - minLength) / currentTreeCount
    }

    println(result)
}