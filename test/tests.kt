import kotlin.test.assertEquals
import org.junit.jupiter.api.Test as test


class Test {
    private val logic = Logic()
    
    @test
    fun testGetDistance2() {
        assertEquals(1, logic.distanceTo1(2))
    }

    @test
    fun testGetDistance3() {
        assertEquals(2, logic.distanceTo1(3))
    }

    @test
    fun testGetDistance12() {
        assertEquals(3, logic.distanceTo1(12))
    }

    @test
    fun testGetDistance23() {
        assertEquals(2, logic.distanceTo1(23))
    }

    @test
    fun testGetDistance1024() {
        assertEquals(31, logic.distanceTo1(1024))
    }

    @test
    fun testGetDistance58() {
        assertEquals(7, logic.distanceTo1(58))
    }

//     Part 2
    @test
    fun testGreaterThan2() {
        assertEquals(4, logic.version2(2))
    }

    @test
    fun testGreaterThan5() {
        assertEquals(10, logic.version2(5))
    }

    @test
    fun testGreaterThan747() {
        assertEquals(806, logic.version2(747))
    }
}