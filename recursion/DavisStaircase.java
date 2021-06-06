package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
 * <p>
 * Davis has a number of staircases in his house and he likes to climb each staircase 1, 2, or 3 steps
 * at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 * Given the respective heights for each of the s staircases in his house, find and print the number of ways
 * he can climb each staircase, module 10^10 + 7 on a new line.
 */
public class DavisStaircase {

    private static final long UPPER_BOUND = 10_000_000_007L;

    private static final Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Computes how many ways there are to reach the top of the staircase with given height
     *
     * @param height of the staircase
     * @return number of ways to reach the top
     */
    public static int stepPerms(int height) {
        if (height <= 1) {
            return 1;
        }
        if (cache.containsKey(height)) {
            return cache.get(height);
        }
        int waysCount = 0;
        for (int step = 1; step <= 3; step++) {
            if (height - step >= 0) {
                waysCount += stepPerms(height - step);
            }
        }
        int result = (int) (waysCount % UPPER_BOUND);
        cache.put(height, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStaircases = scanner.nextInt();
        for (int i = 0; i < numOfStaircases; i++) {
            int height = scanner.nextInt();
            System.out.println(stepPerms(height));
        }
    }
}
