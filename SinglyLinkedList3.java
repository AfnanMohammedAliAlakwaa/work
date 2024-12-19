public class SinglyLinkedList3 {
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
    public SinglyLinkedList3() {
        this.head = null;
    }

    // Method to add a new node at the end of the list
    public void add(int data) {
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

    // Method to calculate the size of the list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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
        SinglyLinkedList3 list = new SinglyLinkedList3();

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);


        // Display the list
        System.out.print("Singly Linked List: ");
        list.display();

        // Get the size of the list
        System.out.println("Size of the list: " + list.size());
    }
}


