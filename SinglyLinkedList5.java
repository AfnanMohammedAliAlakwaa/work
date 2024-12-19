public class SinglyLinkedList5 {
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

    // Constructor
    public SinglyLinkedList5() {
        this.head = null;
    }

    // Method to add a new node at the end
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

    // Method to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Static method to concatenate two lists
    public static SinglyLinkedList5 concatenate(SinglyLinkedList5 L, SinglyLinkedList5 M) {
        if (L.head == null) return M; // L is empty
        if (M.head == null) return L; // M is empty

        // Find the tail of L
        Node tail = L.head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Link the tail of L to the head of M
        tail.next = M.head;

        return L; // Return L as the concatenated list
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList5 L = new SinglyLinkedList5();
        SinglyLinkedList5 M = new SinglyLinkedList5();

        // Add elements to L
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        // Add elements to M
        M.addLast(4);
        M.addLast(5);
        M.addLast(6);

        // Display both lists
        System.out.print("List L: ");
        L.display();
        System.out.print("List M: ");
        M.display();

        // Concatenate L and M
        SinglyLinkedList5 LPrime = SinglyLinkedList5.concatenate(L, M);

        // Display the concatenated list
        System.out.print("Concatenated List L': ");
        LPrime.display();
    }
}


