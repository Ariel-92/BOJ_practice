fun main() {
    val (cardCount, blackJack) = readln().split(" ").map { it.toInt() }
    val cards : ArrayList<Int> = arrayListOf()
    readln().split(" ").map { cards.add(it.toInt()) }

    var result = 0
    for (i in cardCount - 1 downTo 2) {
        for(j in i - 1 downTo 1) {
            for(k in j - 1 downTo 0) {
                val temp = cards[i] + cards[j] + cards[k]
                if(temp in (result + 1)..blackJack){
                    result = temp
                    break
                }
            }
        }
    }

    println(result)
}