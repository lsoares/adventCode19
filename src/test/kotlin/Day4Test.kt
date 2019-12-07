import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

object Day4Test {

    @ParameterizedTest
    @ValueSource(ints = [123356, 111111, 112233])
    fun `test part 1 - valid`(test: Int) {
        assertTrue(Day4.isValid1(test))
    }

    @ParameterizedTest
    @ValueSource(ints = [111110, 223450, 123789])
    fun `test part 1 - invalid`(test: Int) {
        assertFalse(Day4.isValid1(test))
    }

    @Test
    fun `find solution part 1`() {
        assertEquals(1873, (136760..595730).count(Day4::isValid1))
    }

    @ParameterizedTest
    @ValueSource(ints = [112233, 111122])
    fun `test part 2 - valid`(test: Int) {
        assertTrue(Day4.isValid2(test))
    }

    @ParameterizedTest
    @ValueSource(ints = [123444, 123456, 111222])
    fun `test part 2 - invalid`(test: Int) {
        assertFalse(Day4.isValid2(test))
    }

    @Test
    fun `find solution part 2`() {
        assertEquals(878, (136760..595730).count(Day4::isValid2))
    }
}