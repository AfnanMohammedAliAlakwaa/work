public class SinglyLinkedList<T> {
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
    public SinglyLinkedList() {
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

    // Overriding the equals method to compare two SinglyLinkedLists
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same reference means the lists are equal
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class means the lists are not equal
        }

        @SuppressWarnings("unchecked")
        SinglyLinkedList<T> other = (SinglyLinkedList<T>) obj;

        Node<T> current1 = this.head;
        Node<T> current2 = other.head;

        // Compare nodes one by one
        while (current1 != null && current2 != null) {
            if (!current1.data.equals(current2.data)) {
                return false; // Data mismatch
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // Check if both lists are exhausted
        return current1 == null && current2 == null;
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

    // Main method to demonstrate the equals method
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        list3.add(1);
        list3.add(4);

        System.out.println("List1: ");
        list1.printList();

        System.out.println("List2: ");
        list2.printList();

        System.out.println("List3: ");
        list3.printList();

        System.out.println("List1 equals List2: " + list1.equals(list2)); // true
        System.out.println("List1 equals List3: " + list1.equals(list3)); // false
    }
}

