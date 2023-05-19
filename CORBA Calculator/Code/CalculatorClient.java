import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/Calculator");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter operation (add/subtract/multiply/divide): ");
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();
                double result;
                switch (operation) {
                    case "add":
                        result = calculator.add(a, b);
                        System.out.println("Result: " + result);
                        break;
                    case "subtract":
                        result = calculator.subtract(a, b);
                        System.out.println("Result: " + result);
                        break;
                    case "multiply":
                        result = calculator.multiply(a, b);
                        System.out.println("Result: " + result);
                        break;
                    case "divide":
                        try {
                            result = calculator.divide(a, b);
                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid operation");
                        break;
                }
                scanner.nextLine(); // consume newline character
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
