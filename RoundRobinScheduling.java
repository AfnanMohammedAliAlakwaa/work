import java.util.LinkedList;
import java.util.Queue;

class Process {
    String name;       // Process name
    int burstTime;     // Time required to complete the process

    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }
}

public class RoundRobinScheduling {
    public static void simulateRoundRobin(Queue<Process> processes, int quantum) {
        System.out.println("Starting Round Robin Scheduling...");

        while (!processes.isEmpty()) {
            // Get the next process from the queue
            Process current = processes.poll();

            // Simulate the process execution
            if (current.burstTime > quantum) {
                System.out.println(current.name + " executed for " + quantum + " units.");
                current.burstTime -= quantum; // Reduce remaining burst time
                processes.add(current); // Re-enqueue the process
            } else {
                System.out.println(current.name + " executed for " + current.burstTime + " units and completed.");
            }
        }

        System.out.println("All processes completed.");
    }

    public static void main(String[] args) {
        // Create a queue for the processes
        Queue<Process> processes = new LinkedList<>();

        // Add processes to the queue
        processes.add(new Process("P1", 10));
        processes.add(new Process("P2", 4));
        processes.add(new Process("P3", 7));
        processes.add(new Process("P4", 12));

        int quantum = 3; // Time slice (quantum)

        // Simulate Round Robin Scheduling
        simulateRoundRobin(processes, quantum);
    }
}



