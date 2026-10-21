import java.util.Scanner;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter triangle height: ");
        int n = sc.nextInt();
        if (n <= 0) { System.out.println("Height must be positive."); return; }
        for (int row = 1; row <= n; row++) {
            for (int j = 0; j < n - row; j++) System.out.print(" ");
            for (int j = 0; j < 2 * row - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
