package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem from hackerrank
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 */
public class SalesByMatch {

    /**
     * Computes number of pairs of socks with matching colors
     *
     * @param sockCount numbers of socks
     * @param sockColors colors represented by integers in range [1, 100]
     * @return number of pairs with matching colors
     */
    public static int sockMerchant(final int sockCount, final List<Integer> sockColors) {
        var colorCounts = new int[101];
        for (var color : sockColors) {
            colorCounts[color]++;
        }
        var pairCount = 0;
        for (var colorCount : colorCounts) {
            pairCount += colorCount / 2;
        }
        return pairCount;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var sockCount = scanner.nextInt();
        var sockColors = new ArrayList<Integer>();
        for (var i = 0; i < sockCount; i++) {
            sockColors.add(scanner.nextInt());
        }
        System.out.println(sockMerchant(sockCount, sockColors));
    }
}
