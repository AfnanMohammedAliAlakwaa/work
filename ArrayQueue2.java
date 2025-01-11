import java.util.Arrays;
public class ArrayQueue2 {
    public class ArrayQueue<E> implements Cloneable {
        private static final int DEFAULT_CAPACITY = 10;
        private E[] data;
        private int front = 0;
        private int size = 0;

        // Constructor
        public ArrayQueue() {
            data = (E[]) new Object[DEFAULT_CAPACITY];
        }

        // Get the size of the queue
        public int size() {
            return size;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Enqueue an element into the queue
        public void enqueue(E element) {
            if (size == data.length) {
                resize(2 * data.length); // Resize if full
            }
            int avail = (front + size) % data.length; // Next available spot
            data[avail] = element;
            size++;
        }

        // Dequeue an element from the queue
        public E dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            E result = data[front];
            data[front] = null; // Help garbage collection
            front = (front + 1) % data.length;
            size--;
            return result;
        }

        // Peek at the front element of the queue
        public E first() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return data[front];
        }

        // Resize the internal array
        private void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % data.length];
            }
            data = newData;
            front = 0; // Reset front
        }

        // Clone method
        @Override
        public ArrayQueue<E> clone() {
            try {
                // Perform a shallow copy
                ArrayQueue<E> cloned = (ArrayQueue<E>) super.clone();

                // Deep copy the internal array
                cloned.data = Arrays.copyOf(this.data, this.data.length);

                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("Clone not supported", e);
            }
        }

        // Main method for testing
        public  void main(String[] args) {
            ArrayQueue<Integer> queue = new ArrayQueue2();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Original queue: " + Arrays.toString(queue.data));

            // Clone the queue
            ArrayQueue<Integer> clonedQueue = queue.clone();

            System.out.println("Cloned queue: " + Arrays.toString(clonedQueue.data));

            // Modify the original queue
            queue.enqueue(40);
            queue.dequeue();

            System.out.println("Modified original queue: " + Arrays.toString(queue.data));
            System.out.println("Cloned queue after modification of original: " + Arrays.toString(clonedQueue.data));
        }
    }

}
