import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertFalse(palindrome.isPalindrome("cat"));
    }
    @Test
    public void testOffByOne(){
        OffByN off = new OffByN(1);
        assertTrue(palindrome.isPalindrome("a", off));
        assertTrue(palindrome.isPalindrome("rq", off));
        assertTrue(palindrome.isPalindrome("ab", off));
        assertTrue(palindrome.isPalindrome("flake", off));
        assertTrue(palindrome.isPalindrome("&%", off));
        assertFalse(palindrome.isPalindrome("aaaaabbb", off));
        assertFalse(palindrome.isPalindrome("cat", off));
    }
}
