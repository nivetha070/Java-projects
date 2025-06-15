import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] categories = new String[100];
        double[] amounts = new double[100];
        int count = 0;
        double total = 0;

        System.out.println("\n\t EXPENSE TRACKER");

        while (true) {
            System.out.println("\n 1. Add Expense\t2. View Expenses\n 3. Total Spent\t4. Exit");
            System.out.print(" Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    if (count >= 100) {
                        System.out.println(" Limit reached!");
                        break;
                    }
                    System.out.print(" Enter category (e.g., Food, Travel,entertainment): ");
                    categories[count] = sc.nextLine();
                    System.out.print(" Enter amount: Rs.");
                    amounts[count] = sc.nextDouble();
                    total += amounts[count];
                    count++;
                    System.out.println(" Expense added!");
                    break;

                case 2: 
                    if (count == 0) {
                        System.out.println(" No expenses yet.");
                    } else {
                        System.out.println(" Your Expenses:");
                        for (int i = 0; i < count; i++) {
                            System.out.printf("  %d. %s - ₹%.2f\n", i + 1, categories[i], amounts[i]);
                        }
                    }
                    break;

                case 3: 
                    System.out.printf(" Total Spent: Rs%.2f\n", total);
                    break;

                case 4: 
                    System.out.println("  Thanks for using Expense Tracker!");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" ❗ Invalid choice.");
            }
        }
    }
}
