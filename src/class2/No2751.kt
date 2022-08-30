import java.util.PriorityQueue
import kotlin.text.StringBuilder

fun main(args : Array<String>) {
    val maxCount : Int = readln().toInt()
    // 퀵정렬로 했을 때 시간초과인데 우선순위큐 이용하면 통과...
    val numbers : PriorityQueue<Int> = PriorityQueue()
    for(i in 1..maxCount)
        numbers.add(readln().toInt())
    // println을 사용하는 것보다 StringBuilder로 문자열 만들어서 출력하는게 더 빠름
    val result = StringBuilder()
    while(!numbers.isEmpty()) {
        result.append(numbers.poll())
        result.append("\n")
    }
    print(result)
}