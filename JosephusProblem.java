import java.util.LinkedList;
import java.util.Queue;
public class JosephusProblem {
    public static int solveJosephus(int n, int k) {
        // Create a queue and initialize it with people (1 to n)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // Simulate the elimination process
        while (queue.size() > 1) {
            // Rotate the queue (dequeue and re-enqueue k-1 people)
            for (int i = 1; i < k; i++) {
                queue.add(queue.remove());
            }
            // Eliminate the k-th person
            queue.remove();
        }

        // The last remaining person is the survivor
        return queue.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 7; // Number of people in the circle
        int k = 3; // Every k-th person is eliminated

        int survivor = solveJosephus(n, k);
        System.out.println("The survivor is person: " + survivor);
    }
}



