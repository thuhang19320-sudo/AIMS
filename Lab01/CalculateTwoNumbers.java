import java.util.Scanner;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First number: ");
        double a = input.nextDouble();
        System.out.print("Second number: ");
        double b = input.nextDouble();
        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        if (b == 0) System.out.println("Quotient: undefined (division by zero)");
        else System.out.println("Quotient: " + (a / b));
    }
}
