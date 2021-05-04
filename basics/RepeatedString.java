package basics;

import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * There is a string, s, of lowercase English letters that is repeated infinitely many times.
 * Given an integer, n, find and print the number of letter a's in the first n letters of the infinite string.
 */
public class RepeatedString {

    private static int countLetter(final String s, final char letter, final int endIndex) {
        var count = 0;
        for (var i = 0; i < endIndex; i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static long repeatedString(final String s, final long n) {
        long aCount = countLetter(s, 'a', s.length());
        long remaining = countLetter(s, 'a', (int) (n % s.length()));
        return aCount * (n / s.length()) + remaining;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var s = scanner.nextLine();
        var n = scanner.nextLong();
        System.out.println(repeatedString(s, n));
    }
}
