public class SinglyLinkedList6 {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Constructor to initialize an empty list
    public SinglyLinkedList6() {
        this.head = null;
    }

    // Method to add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to reverse the list in place
    public void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // Save the next node
            current.next = prev;      // Reverse the link
            prev = current;           // Move prev forward
            current = next;           // Move current forward
        }

        head = prev; // Update head to the new first node
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

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList6 list = new SinglyLinkedList6();

        // Add elements to the list
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Display the original list
        System.out.print("Original List: ");
        list.display();

        // Reverse the list
        list.reverse();

        // Display the reversed list
        System.out.print("Reversed List: ");
        list.display();
    }
}


