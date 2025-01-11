import java.util.Stack;
public class RecursiveStackClear {
    public static void clearStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();

        clearStack(stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack before clearing: " + stack);

        clearStack(stack);

        System.out.println("Stack after clearing: " + stack);
    }
}


