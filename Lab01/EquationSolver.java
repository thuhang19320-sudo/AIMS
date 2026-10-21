import java.util.Scanner;

public class EquationSolver {
    private static final double EPS = 1e-10;
    private static boolean zero(double a) { return Math.abs(a) < EPS; }

    private static void linear(double a, double b) {
        if (zero(a)) System.out.println(zero(b) ? "Infinitely many solutions" : "No solution");
        else System.out.println("x = " + (-b / a));
    }

    private static void system(double a11, double a12, double b1,
                               double a21, double a22, double b2) {
        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;
        if (!zero(d)) {
            System.out.println("x1 = " + (d1 / d) + ", x2 = " + (d2 / d));
        } else if (zero(d1) && zero(d2)) {
            // All coefficient equations must be checked to handle zero rows correctly.
            boolean zeroCoefficients = zero(a11) && zero(a12) && zero(a21) && zero(a22);
            if (zeroCoefficients && (!zero(b1) || !zero(b2)))
                System.out.println("No solution");
            else if ((zero(a11) && zero(a12) && !zero(b1)) ||
                     (zero(a21) && zero(a22) && !zero(b2)))
                System.out.println("No solution");
            else System.out.println("Infinitely many solutions");
        } else System.out.println("No solution");
    }

    private static void quadratic(double a, double b, double c) {
        if (zero(a)) { linear(b, c); return; }
        double delta = b * b - 4 * a * c;
        if (delta < -EPS) System.out.println("No real roots");
        else if (zero(delta)) System.out.println("Double root x = " + (-b / (2 * a)));
        else {
            double root = Math.sqrt(delta);
            System.out.println("x1 = " + ((-b + root) / (2 * a)));
            System.out.println("x2 = " + ((-b - root) / (2 * a)));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Linear equation ax+b=0");
        System.out.println("2. Two-variable linear system");
        System.out.println("3. Quadratic equation ax^2+bx+c=0");
        System.out.print("Choose (1-3): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter a b: ");
                linear(sc.nextDouble(), sc.nextDouble());
                break;
            case 2:
                System.out.print("Enter a11 a12 b1 a21 a22 b2: ");
                system(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),
                       sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                break;
            case 3:
                System.out.print("Enter a b c: ");
                quadratic(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                break;
            default: System.out.println("Invalid choice");
        }
    }
}
