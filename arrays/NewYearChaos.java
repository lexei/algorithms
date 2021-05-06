package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * <p>
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 * Each person wears a sticker indicating their initial position in the queue from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions,
 * but they still wear their original sticker. One person can bribe at most two others.
 * <p>
 * Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 * Example:
 * If person 5 bribes person 4, the queue will look like this: 1, 2, 3, 5, 4, 6, 7, 8.
 * Only 1 bribe is required. Print 1.
 */
public class NewYearChaos {

    public static void minimumBribes(final List<Integer> queue) {
        if (isTooChaotic(queue)) {
            System.out.println("Too chaotic");
            return;
        }
        var totalBribes = 0L;
        for (var i = 0; i < queue.size() - 1; i++) {
            var bribes = 0;
            for (var j = 1; j < queue.size() - i; j++) {
                if (queue.get(j - 1) > queue.get(j)) {
                    Collections.swap(queue, j - 1, j);
                    bribes++;
                }
            }
            if (bribes == 0) {
                break;
            }
            totalBribes += bribes;
        }
        System.out.println(totalBribes);
    }

    private static boolean isTooChaotic(final List<Integer> queue) {
        for (var i = 0; i < queue.size(); i++) {
            if (queue.get(i) > i + 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var tests = scanner.nextInt();
        for (var t = 0; t < tests; t++) {
            var queueSize = scanner.nextInt();
            var queue = new ArrayList<Integer>();
            for (var i = 0; i < queueSize; i++) {
                queue.add(scanner.nextInt());
            }
            minimumBribes(new ArrayList<>(queue));
        }
    }
}
