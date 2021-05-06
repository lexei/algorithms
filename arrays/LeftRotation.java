package arrays;

import java.util.Scanner;

/**
 * Problem from Hackerrank
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class LeftRotation {

    private static void rotateLeftOnce(final int[] arr) {
        var first = arr[0];
        for (var i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    /**
     * Performs n array left rotations on arr
     *
     * @param arr array of ints
     * @param n number of left rotations to perform
     */
    public static void rotLeft(final int[] arr, final int n) {
        var leftRotations = n % arr.length;
        for (var i = 0; i < leftRotations; i++) {
            rotateLeftOnce(arr);
        }
    }

    public static void main(final String[] args) {
        var scanner = new Scanner(System.in);
        var size = scanner.nextInt();
        var numOfRotations = scanner.nextInt();
        var arr = new int[size];
        for (var i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        rotLeft(arr, numOfRotations);
        for (var i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
