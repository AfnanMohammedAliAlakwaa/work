
    public class LinkedQueue<E> {
        // Node class
        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> head = null; // Head of the queue
        private Node<E> tail = null; // Tail of the queue
        private int size = 0;        // Number of elements in the queue

        // Constructor
        public LinkedQueue() {}

        // Get the size of the queue
        public int size() {
            return size;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Enqueue an element
        public void enqueue(E element) {
            Node<E> newNode = new Node<>(element, null);
            if (isEmpty()) {
                head = newNode;
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
            size++;
        }

        // Dequeue an element
        public E dequeue() {
            if (isEmpty()) {
                return null;
            }
            E element = head.getElement();
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = null; // Queue is now empty
            }
            return element;
        }

        // Peek at the front element
        public E first() {
            if (isEmpty()) {
                return null;
            }
            return head.getElement();
        }

        // Concatenate method
        public void concatenate(LinkedQueue<E> Q2) {
            if (Q2.isEmpty()) {
                return; // Nothing to concatenate
            }

            // Link the tail of the original queue to the head of Q2
            if (this.isEmpty()) {
                // If the original queue is empty, adopt Q2's nodes
                this.head = Q2.head;
                this.tail = Q2.tail;
            } else {
                // Link the tail of the original queue to the head of Q2
                this.tail.setNext(Q2.head);
                this.tail = Q2.tail;
            }

            // Update size
            this.size += Q2.size();

            // Clear Q2
            Q2.head = null;
            Q2.tail = null;
            Q2.size = 0;
        }

        // Main method for testing
        public static void main(String[] args) {
            LinkedQueue<Integer> Q1 = new LinkedQueue<>();
            LinkedQueue<Integer> Q2 = new LinkedQueue<>();

            Q1.enqueue(1);
            Q1.enqueue(2);
            Q1.enqueue(3);

            Q2.enqueue(4);
            Q2.enqueue(5);
            Q2.enqueue(6);

            System.out.println("Q1 size before concatenate: " + Q1.size()); // Output: 3
            System.out.println("Q2 size before concatenate: " + Q2.size()); // Output: 3

            Q1.concatenate(Q2);

            System.out.println("Q1 size after concatenate: " + Q1.size()); // Output: 6
            System.out.println("Q2 size after concatenate: " + Q2.size()); // Output: 0

            // Print Q1 elements
            while (!Q1.isEmpty()) {
                System.out.print(Q1.dequeue() + " ");
            }
            // Output: 1 2 3 4 5 6
        }
    }


