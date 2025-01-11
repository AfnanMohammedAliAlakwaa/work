import java.util.Arrays;

    public class ArrayQueue<E> {
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

        // Rotate the queue
        public void rotate() {
            if (isEmpty()) {
                return; // No need to rotate an empty queue
            }
            front = (front + 1) % data.length; // Move the front pointer forward
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

        // Main method for testing
        public static void main(String[] args) {
            ArrayQueue<Integer> queue = new ArrayQueue<>();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Queue after enqueue operations: " + Arrays.toString(queue.data));

            queue.rotate(); // Rotate the queue
            System.out.println("Queue after first rotate: " + Arrays.toString(queue.data) + ", Front: " + queue.front);

            queue.rotate(); // Rotate the queue again
            System.out.println("Queue after second rotate: " + Arrays.toString(queue.data) + ", Front: " + queue.front);

            System.out.println("Front element after rotates: " + queue.first());
        }
    }



