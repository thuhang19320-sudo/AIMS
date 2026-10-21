package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixAddition {
    private static double[][] read(Scanner sc, int rows, int cols, String name) {
        double[][] matrix = new double[rows][cols];
        System.out.println("Enter matrix " + name + ":");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print(name + "[" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextDouble();
            }
        return matrix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows and columns: ");
        int rows = sc.nextInt(), cols = sc.nextInt();
        if (rows <= 0 || cols <= 0) { System.out.println("Invalid matrix size."); return; }
        double[][] a = read(sc, rows, cols, "A");
        double[][] b = read(sc, rows, cols, "B");
        System.out.println("A + B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) System.out.print((a[i][j] + b[i][j]) + " ");
            System.out.println();
        }
    }
}
