fun main(args : Array<String>) {
    val apartment : ArrayList<ArrayList<Int>> = arrayListOf()
    apartment.add(arrayListOf())

    for(i in 0..14) {
        apartment[0].add(i)
    }

    for(floor in 1..14) {
        apartment.add(arrayListOf())
        for(unit in 0..14) {
            var temp = 0
            for(underfloor in 0..unit) {
                temp += apartment[floor - 1][underfloor]
            }
            apartment[floor].add(temp)
        }
    }

    val caseAmount : Int = readln().toInt()
    val floors : ArrayList<Pair<Int, Int>> = arrayListOf()

    for(i in 0 until caseAmount) {
        floors.add(Pair(readln().toInt(), readln().toInt()))
    }

    for(i in 0 until caseAmount) {
        println(apartment[floors[i].first][floors[i].second])
    }
}