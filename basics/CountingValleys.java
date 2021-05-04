package basics;

import java.util.Scanner;

/**
 * Problem from Hackerrank
 * hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * An avid hiker keeps meticulous records of their hikes.
 * During the last hike that took exactly steps steps,
 * for every step it was noted if it was an uphill, U, or a downhill, D step.
 * Hikes always start and end at sea level, and each step up or down
 * represents a 1 unit change in altitude. We define the following terms:
 *     A mountain is a sequence of consecutive steps above sea level,
 * starting with a step up from sea level and ending with a step down to sea level.
 *     A valley is a sequence of consecutive steps below sea level,
 * starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike,
 * find and print the number of valleys walked through.
 */
public class CountingValleys {

    public static int countingValleys(final int steps, final String path) {
        var valleyCount = 0;
        var level = 0;
        for (var i = 0; i < steps; i++) {
            var step = path.charAt(i);
            if (step == 'U') {
                if (level == -1) {
                    valleyCount++;
                }
                level++;
            } else if (step == 'D') {
                level--;
            }
        }
        return valleyCount;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var steps = scanner.nextInt();
        var path = scanner.next();
        System.out.println(countingValleys(steps, path));
    }
}
