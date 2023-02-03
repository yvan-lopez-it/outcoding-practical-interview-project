import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Project04_Test {
    @Test
    public void testFirstHexagonalNumber() {
        int expected = 1;
        int n = 1;
        int result = Project04_.hexagonalNumber(n);
        assertEquals(expected, result);
    }

    @Test
    public void testSecondHexagonalNumber() {
        int expected = 6;
        int n = 2;
        int result = Project04_.hexagonalNumber(n);
        assertEquals(expected, result);
    }

    @Test
    public void testNegativeInput() {
        int n = -1;
        try {
            Project04_.hexagonalNumber(n);
        } catch (IllegalArgumentException e) {
            assertEquals("n must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void testZeroInput() {
        int n = 0;
        try {
            Project04_.hexagonalNumber(n);
        } catch (IllegalArgumentException e) {
            assertEquals("n must be a positive integer", e.getMessage());
        }
    }
}
