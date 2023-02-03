import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Project02_Test {
    @Test
    public void testIsPalindrome_withPalindromeString_returnsTrue() {
        String input = "level";
        assertTrue(Project02_.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome_withNonPalindromeString_returnsFalse() {
        String input = "hello";
        assertFalse(Project02_.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome_withEmptyString_returnsTrue() {
        String input = "";
        assertTrue(Project02_.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome_withStringOfLengthOne_returnsTrue() {
        String input = "a";
        assertTrue(Project02_.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome_withStringContainingNumbersAndSpecialCharacters_returnsTrue() {
        String input = "A man, a plan, a canal: Panama";
        assertFalse(Project02_.isPalindrome(input));
    }
}
