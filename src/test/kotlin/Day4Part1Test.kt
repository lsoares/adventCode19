import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

object Day4Part1Test {

    @Test
    fun `find solution`() {
        assertEquals(1873, (136760..595730).count(Day4Part1::isValid))
    }

    @ParameterizedTest
    @ValueSource(ints = [123356, 111111, 112233])
    fun `test is valid`(test: Int) {
        assertTrue(Day4Part1.isValid(test))
    }

    @ParameterizedTest
    @ValueSource(ints = [111110, 223450, 123789])
    fun `test is invalid`(test: Int) {
        assertFalse(Day4Part1.isValid(test))
    }
}