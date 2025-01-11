import java.util.Stack;
public class StackTransfer {
    public static void transfer(Stack<Integer> S, Stack<Integer> T) {
        // While S is not empty, pop elements from S and push them onto T
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    public static void main(String[] args) {
        // Example usage
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        // Fill stack S with elements
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
        S.push(5); // Top of the stack

        System.out.println("Stack S before transfer: " + S);
        System.out.println("Stack T before transfer: " + T);

        // Perform transfer
        transfer(S, T);

        System.out.println("Stack S after transfer: " + S);
        System.out.println("Stack T after transfer: " + T);
    }
}


