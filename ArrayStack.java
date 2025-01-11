import java.util.Arrays;

    public class ArrayStack<E> implements Cloneable {
        private static final int DEFAULT_CAPACITY = 10;
        private E[] data;
        private int size = 0;

        // Constructor
        public ArrayStack() {
            data = (E[]) new Object[DEFAULT_CAPACITY];
        }

        // Push an element onto the stack
        public void push(E element) {
            if (size == data.length) {
                resize(2 * data.length); // Resize if array is full
            }
            data[size++] = element;
        }

        // Pop an element from the stack
        public E pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            E result = data[--size];
            data[size] = null; // Help garbage collection
            return result;
        }

        // Peek at the top element
        public E peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[size - 1];
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Get the size of the stack
        public int size() {
            return size;
        }

        // Resize the internal array
        private void resize(int newCapacity) {
            data = Arrays.copyOf(data, newCapacity);
        }

        // Implement the clone method
        @Override
        public ArrayStack<E> clone() {
            try {
                // Perform a shallow copy
                ArrayStack<E> cloned = (ArrayStack<E>) super.clone();

                // Deep copy the internal array
                cloned.data = Arrays.copyOf(this.data, this.data.length);

                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("Clone not supported", e);
            }
        }

        // Main method for testing
        public static void main(String[] args) {
            ArrayStack<Integer> stack = new ArrayStack<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Original stack size: " + stack.size());
            System.out.println("Top of original stack: " + stack.peek());

            // Clone the stack
            ArrayStack<Integer> clonedStack = stack.clone();

            System.out.println("Cloned stack size: " + clonedStack.size());
            System.out.println("Top of cloned stack: " + clonedStack.peek());

            // Modify original stack
            stack.pop();
            System.out.println("After popping original stack:");
            System.out.println("Original stack size: " + stack.size());
            System.out.println("Cloned stack size: " + clonedStack.size());
        }
    }


