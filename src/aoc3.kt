import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val logic = Logic()

    println(logic.version1(347991))
    println(logic.version2(347991))
    println(logic.version1_naive(347991))
}

class Logic {

    fun version1(square: Int): Int {
        var side = ceil(sqrt(square.toDouble())).toInt()
        if (side % 2 == 0) { side ++ }
        val corners = (0..3).map { side * side - it * (side - 1) }
        val distanceToCorner = corners.map { abs(it - square) }.min()
        return side - 1 - distanceToCorner!!
    }

    fun version1_naive(square: Int):Int {
        var (x, y, stepsBeforeTurn, stepstaken) = listOf(0, 0, 0, 0)
        var xAxis = false
        var positive = false

        for(squarenumber in 2..square){
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
        return Math.abs(x) + Math.abs(y)
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