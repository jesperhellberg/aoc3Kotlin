import kotlin.test.assertEquals
import org.junit.jupiter.api.Test as test


class Test {
    private val logic = Logic()
    
    @test
    fun testGetDistance2() {
        assertEquals(1, logic.version1_naive(2))
    }

    @test
    fun testGetDistance3() {
        assertEquals(2, logic.version1_naive(3))
    }

    @test
    fun testGetDistance12() {
        assertEquals(3, logic.version1_naive(12))
    }

    @test
    fun testGetDistance23() {
        assertEquals(2, logic.version1_naive(23))
    }

    @test
    fun testGetDistance1024() {
        assertEquals(31, logic.version1_naive(1024))
    }

    @test
    fun testGetDistance58() {
        assertEquals(7, logic.version1_naive(58))
    }


    @test
    fun testGetDistance2v1() {
        assertEquals(1, logic.version1(2))
    }

    @test
    fun testGetDistance3v1() {
        assertEquals(2, logic.version1(3))
    }

    @test
    fun testGetDistance12v1() {
        assertEquals(3, logic.version1(12))
    }

    @test
    fun testGetDistance23v1() {
        assertEquals(2, logic.version1(23))
    }

    @test
    fun testGetDistance1024v1() {
        assertEquals(31, logic.version1(1024))
    }

    @test
    fun testGetDistance58v1() {
        assertEquals(7, logic.version1(58))
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