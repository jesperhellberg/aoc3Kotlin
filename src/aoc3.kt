fun main(args: Array<String>) {
    val logic = Logic()

    println(logic.distanceTo1(347991))
    println(logic.version2(347991))

}

class Logic {

    fun distanceTo1(square: Int):Int {
        val coord = getCoord(square)
        return Math.abs(coord.first ) + Math.abs(coord.second)
    }


    fun getCoord(max: Int) : Pair<Int, Int> {
        var (x, y, stepsBeforeTurn, stepstaken) = listOf(0, 0, 0, 0)
        var xAxis = false
        var positive = false

        for(squarenumber in 2..max){
            if (stepstaken == stepsBeforeTurn) {
                if (!xAxis) {
                    positive = !positive
                    stepsBeforeTurn ++
                }
                xAxis = !xAxis
                stepstaken = 0
            }
            if (xAxis && positive) {
                x++
            }
            if (xAxis && !positive) {
                x--
            }
            if (!xAxis && positive) {
                y++
            }
            if (!xAxis && !positive) {
                y--
            }
            stepstaken++

        }
        return Pair(x, y)
    }


   fun version2(max: Int) : Int {
        var (x, y, stepsBeforeTurn, stepstaken, squareValue) = listOf(25, 25, 0, 0, 1)
        var xAxis = false
        var positive = false

        val matrix = Array(50){IntArray(50)}
        matrix[x][y] = 1

        fun calculateSquareValue(x: Int, y: Int): Int {
            return (-1..1).sumBy { i -> (-1..1).sumBy { j -> matrix[x + i][y + j] } }
        }

        while(squareValue <= max ){
            if (stepstaken == stepsBeforeTurn) {
                if (!xAxis) {
                    positive = !positive
                    stepsBeforeTurn ++
                }
                xAxis = !xAxis
                stepstaken = 0
            }
            if (xAxis && positive) {
                x++
            }
            if (xAxis && !positive) {
                x--
            }
            if (!xAxis && positive) {
                y++
            }
            if (!xAxis && !positive) {
                y--
            }

            matrix[x][y] = calculateSquareValue(x, y)
            squareValue = matrix[x][y]
            stepstaken++

        }
        return squareValue
    }
}