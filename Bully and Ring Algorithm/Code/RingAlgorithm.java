import java.util.*;

public class RingAlgorithm {

    public static void main(String[] args) {
        // initialize the variables
        int n; // number of nodes
        int[] nodeIDs; // array of node IDs
        int coordinator = -1; // coordinator node ID
        Scanner sc = new Scanner(System.in);
        
        // take input from user for number of nodes and node IDs
        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();
        nodeIDs = new int[n];
        System.out.println("Enter IDs of nodes:");
        for (int i = 0; i < n; i++) {
            nodeIDs[i] = sc.nextInt();
        }
        
        // send messages in a ring to determine the coordinator node
        int maxID = -1;
        for (int i = 0; i < n; i++) {
            int successor = (i + 1) % n;
            System.out.println("Node " + nodeIDs[i] + " sends an election message to node " + nodeIDs[successor]);
            if (nodeIDs[i] > maxID) {
                maxID = nodeIDs[i];
            }
        }
        
        // wait for the coordinator to send the coordinator message
        while (coordinator == -1) {
            for (int i = 0; i < n; i++) {
                int predecessor = (i - 1 + n) % n;
                int successor = (i + 1) % n;
                System.out.println("Node " + nodeIDs[i] + " waits for message from node " + nodeIDs[predecessor]);
                int message = sc.nextInt();
                if (message == nodeIDs[i]) {
                    System.out.println("Node " + nodeIDs[i] + " is the coordinator");
                    coordinator = nodeIDs[i];
                    break;
                } else {
                    System.out.println("Node " + nodeIDs[i] + " forwards message " + message + " to node " + nodeIDs[successor]);
                }
            }
        }
        
        System.out.println("Coordinator node is " + coordinator);
    }
}
