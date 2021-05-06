package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * <p>
 * Given 6x6 2d array arr,
 * An hourglass in arr is a subset of values with indices
 * falling in this pattern in arr's graphical representation:
 * a b c
 * d
 * e f g
 * There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in arr,
 * then print the maximum hourglass sum. The array will always be 6x6.
 */
public class Hourglass {

    private static final int SIZE = 6;

    private static List<List<Integer>> enterArr() {
        var arr = new ArrayList<List<Integer>>();
        var scanner = new Scanner(System.in);
        for (var i = 0; i < SIZE; i++) {
            arr.add(new ArrayList<>());
            for (var j = 0; j < SIZE; j++) {
                var value = scanner.nextInt();
                arr.get(i).add(value);
            }
        }
        return arr;
    }

    private static int getLocalSum(List<List<Integer>> arr, int row, int col) {
        var sum = 0;
        for (var i = row - 1; i <= row + 1; i++) {
            for (var j = col - 1; j <= col + 1; j++) {
                sum += arr.get(i).get(j);
            }
        }
        return sum - arr.get(row).get(col - 1) - arr.get(row).get(col + 1);
    }

    public static int hourglassSum(final List<List<Integer>> arr) {
        var maxSum = Integer.MIN_VALUE;
        for (var i = 1; i < SIZE - 1; i++) {
            for (var j = 1; j < SIZE - 1; j++) {
                maxSum = Math.max(getLocalSum(arr, i, j), maxSum);
            }
        }
        return maxSum;
    }

    public static void main(final String[] args) {
        var arr = enterArr();
        System.out.println(hourglassSum(arr));
    }
}
