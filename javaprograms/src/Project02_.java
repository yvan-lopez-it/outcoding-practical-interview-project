import java.util.function.Function;

public class Project02_ {

    public static void main(String[] args) {
        String input = "level";
        System.out.println(input + " is a palindrome? " + isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {
        Function<String, Boolean> isPalindrome = s -> {
            String reversed = new StringBuilder(s)
                    .reverse()
                    .toString();
            return reversed.equals(s);
        };

        return isPalindrome.apply(input);
    }
}
