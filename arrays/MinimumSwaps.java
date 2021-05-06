package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 * You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n]
 * without any duplicates. You are allowed to swap any two elements.
 * Find the minimum number of swaps required to sort the array in ascending order.
 */
public class MinimumSwaps {

    private static int minimumSwaps(final int[] arr) {
        var swapCount = 0;
        for (var i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
                swapCount++;
            }
        }
        return swapCount;
    }

    private static void swap(final int[] arr, final int i, final int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var arraySize = scanner.nextInt();
        var numbers = new int[arraySize];
        for (var i = 0; i < arraySize; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(minimumSwaps(numbers));

        System.out.println(Arrays.toString(numbers));
    }
}
