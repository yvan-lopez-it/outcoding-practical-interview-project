import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HexagonalNumber {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single integer argument.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        System.out.println("The " + n + "th hexagonal number is: " + hexagonalNumber(n));
    }


    public static int hexagonalNumber(int n) {
        return n * (2 * n - 1);
    }
}
