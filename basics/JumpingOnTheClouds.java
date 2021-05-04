package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is
 * equal to the number of the current cloud plus 1 or 2.
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting position
 * to the last cloud. It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 */
public class JumpingOnTheClouds {

    public static int jumpingOnClouds(final List<Integer> clouds) {
        var jumpCount = 0;
        var cloudIndex = 0;
        while (cloudIndex < clouds.size()) {
            if (cloudIndex + 2 < clouds.size() && clouds.get(cloudIndex + 2) == 0) {
                cloudIndex += 2;
            } else {
                cloudIndex++;
            }
            jumpCount++;
        }
        return jumpCount - 1;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var numOfClouds = scanner.nextInt();
        var clouds = new ArrayList<Integer>();
        for (var i = 0; i < numOfClouds; i++) {
            clouds.add(scanner.nextInt());
        }
        System.out.println(jumpingOnClouds(clouds));
    }
}
