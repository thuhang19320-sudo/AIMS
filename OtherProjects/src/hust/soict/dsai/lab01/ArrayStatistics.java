package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) { System.out.println("Array must not be empty."); return; }
        double[] a = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = sc.nextDouble();
            sum += a[i];
        }
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / n));
    }
}
