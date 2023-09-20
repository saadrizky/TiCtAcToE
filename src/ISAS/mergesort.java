package ISAS;

import java.util.Arrays;
import java.util.Scanner;

public class mergesort {

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int midpoint = array.length / 2;
        int[] leftArray = new int[midpoint];
        int[] rightArray = new int[array.length - midpoint];

        for (int i = 0; i < midpoint; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midpoint; i < array.length; i++) {
            rightArray[i - midpoint] = array[i];
        }

        sort(leftArray);
        sort(rightArray);

        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] resultArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                resultArray[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                resultArray[resultIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < leftArray.length) {
            resultArray[resultIndex] = leftArray[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < rightArray.length) {
            resultArray[resultIndex] = rightArray[rightIndex];
            rightIndex++;
            resultIndex++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int length = scanner.nextInt();

        int[] array = new int[length];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        mergesort.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
