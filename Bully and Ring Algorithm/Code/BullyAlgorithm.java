import java.util.Scanner;

public class BullyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] processes = new int[n];

        System.out.println("Enter the process IDs:");
        for (int i = 0; i < n; i++) {
            processes[i] = sc.nextInt();
        }

        System.out.print("Enter the process ID initiating the election: ");
        int initiatingProcess = sc.nextInt();

        System.out.println("Election initiated by process " + initiatingProcess);
        int coordinator = initiateElection(processes, initiatingProcess);
        System.out.println("Coordinator process is " + coordinator);

        sc.close();
    }

    public static int initiateElection(int[] processes, int initiatingProcess) {
        int coordinator = initiatingProcess;

        for (int i = initiatingProcess + 1; i < processes.length; i++) {
            if (processes[i] > coordinator) {
                System.out.println("Process " + initiatingProcess + " sends message to process " + i);
                if (sendMessage(i)) {
                    System.out.println("Process " + i + " responded to process " + initiatingProcess);
                    coordinator = i;
                }
            }
        }

        for (int i = 0; i < initiatingProcess; i++) {
            System.out.println("Process " + initiatingProcess + " sends message to process " + i);
            if (sendMessage(i)) {
                System.out.println("Process " + i + " responded to process " + initiatingProcess);
                coordinator = i;
            }
        }

        return coordinator;
    }

    public static boolean sendMessage(int process) {
        // Simulating message sending and receiving
        return true;
    }
}


