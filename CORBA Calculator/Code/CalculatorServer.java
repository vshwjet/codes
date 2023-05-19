import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl calculator = new CalculatorImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Calculator", calculator);
            System.out.println("Calculator server is running...");
        } catch (RemoteException e) {
            System.out.println("Error starting calculator server: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
