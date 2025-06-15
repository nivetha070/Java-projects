import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BMIApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "bmi_history.txt";

        System.out.println("\n=== BMI & Health Tracker ===");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your height (in meters): ");
        double height = sc.nextDouble();

        System.out.print("Enter your weight (in kg): ");
        double weight = sc.nextDouble();

        double bmi = weight / (height * height);
        double idealWeight = 22 * height * height;  

        String category = "";
        String suggestion = "";

        if (bmi < 18.5) {
            category = "Underweight";
            suggestion = "Eat nutrient-rich food & gain healthy weight.";
        } else if (bmi < 25) {
            category = "Normal weight";
            suggestion = "Keep up your balanced lifestyle!";
        } else if (bmi < 30) {
            category = "Overweight";
            suggestion = "Include exercise and control calorie intake.";
        } else {
            category = "Obese";
            suggestion = "Consult a doctor and follow a weight loss plan.";
        }

        // Output
        System.out.printf("\nHello %s, your BMI is: %.2f\n", name, bmi);
        System.out.printf("Category: %s\n", category);
        System.out.printf("Suggestion: %s\n", suggestion);
        System.out.printf("Your ideal weight (approx.): %.2f kg\n", idealWeight);

        // Save to file
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Name: " + name + ", Height: " + height + "m, Weight: " + weight + "kg, BMI: " + String.format("%.2f", bmi) + ", Category: " + category + "\n");
            writer.close();
            System.out.println("\n BMI data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }

        sc.close();
    }
}
