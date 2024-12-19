public class SinglyLinkedList4 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and tail of the list
    private Node head;
    private Node tail;

    // Constructor to initialize an empty list
    public SinglyLinkedList4() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to remove the first node of the list
    private Node removeFirst() {
        if (head == null) { // Empty list
            return null;
        }
        Node removedNode = head;
        head = head.next;
        if (head == null) { // List becomes empty
            tail = null;
        }
        removedNode.next = null; // Isolate the removed node
        return removedNode;
    }

    // Method to rotate the list
    public void rotate() {
        if (head == null || head.next == null) {
            // No rotation needed if the list is empty or has only one element
            return;
        }

        // Remove the first node
        Node removedNode = removeFirst();

        // Add the removed node to the end of the list
        tail.next = removedNode;
        tail = removedNode;
    }

    // Method to display the elements of the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        SinglyLinkedList4 list = new SinglyLinkedList4();

        // Add elements to the list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        // Display the original list
        System.out.print("Original List: ");
        list.display();

        // Rotate the list
        list.rotate();

        // Display the list after rotation
        System.out.print("After 1st Rotation: ");
        list.display();

        // Rotate the list again
        list.rotate();

        // Display the list after the second rotation
        System.out.print("After 2nd Rotation: ");
        list.display();
    }
}


