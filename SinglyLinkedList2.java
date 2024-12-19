public class SinglyLinkedList2<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Reference to the first node

    // Constructor to initialize an empty list


    public SinglyLinkedList2() {
        this.head = null;
    }

    // Method to add an element to the end of the list
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
        }
    }

    // Method to find the second-to-last node
    public T findSecondToLast() {
        if (head == null || head.next == null) {
            throw new IllegalStateException("List must have at least two nodes to find the second-to-last node.");
        }

        Node<T> current = head;

        // Traverse until the node before the last node
        while (current.next.next != null) {
            current = current.next;
        }

        return current.data;
    }

    // Method to print the elements of the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to demonstrate the findSecondToLast method
    public static void main(String[] args) {
        SinglyLinkedList2<Integer> list = new SinglyLinkedList2<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("List: ");
        list.printList();

        try {
            System.out.println("Second-to-last node: " + list.findSecondToLast()); // Output should be 30
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Test with smaller lists
        SinglyLinkedList2<Integer> singleNodeList = new SinglyLinkedList2<>();
        singleNodeList.add(10);
        try {
            System.out.println("Second-to-last node: " + singleNodeList.findSecondToLast()); // Should throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        SinglyLinkedList2<Integer> emptyList = new SinglyLinkedList2<>();
        try {
            System.out.println("Second-to-last node: " + emptyList.findSecondToLast()); // Should throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

