import java.util.Scanner;

public class DaysOfMonth {
    private static final String[] MONTHS = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final String[] ABBR = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static int parseMonth(String input) {
        String s = input.trim();
        if (s.matches("[0-9]+")) {
            try { int value = Integer.parseInt(s); return value >= 1 && value <= 12 ? value : -1; }
            catch (NumberFormatException ex) { return -1; }
        }
        for (int i = 0; i < 12; i++) {
            if (s.equalsIgnoreCase(MONTHS[i]) || s.equalsIgnoreCase(ABBR[i]) ||
                s.equalsIgnoreCase(ABBR[i] + ".") ||
                (i == 8 && s.equalsIgnoreCase("Sept."))) return i + 1;
        }
        return -1;
    }
    private static boolean leap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month;
        do {
            System.out.print("Enter month (name, abbreviation or 1-12): ");
            month = parseMonth(sc.nextLine());
            if (month < 1) System.out.println("Invalid month. Try again.");
        } while (month < 1);
        int year = -1;
        while (year < 0) {
            System.out.print("Enter full non-negative year: ");
            String s = sc.nextLine().trim();
            if (s.matches("0|[1-9][0-9]*")) {
                try { year = Integer.parseInt(s); } catch (NumberFormatException ex) { /* retry */ }
            }
            if (year < 0) System.out.println("Invalid year. Try again.");
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && leap(year)) days[1] = 29;
        System.out.println(MONTHS[month - 1] + " " + year + " has " + days[month - 1] + " days.");
    }
}
