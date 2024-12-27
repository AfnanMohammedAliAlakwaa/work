public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E e, Node<E> p, Node<E> n) {
        Node<E> x = new Node<>(e, p, n);
        p.setNext(x);
        n.setPrev(x);
        size++;
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    private E remove(Node<E> x) {
        Node<E> p = x.getPrev();
        Node<E> n = x.getNext();
        p.setNext(n);
        n.setPrev(p);
        size--;
        return x.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // 1. Method for finding the middle node using "link hopping" without knowing the size
    public Node<E> findMiddle() {
        if (isEmpty()) return null;
        Node<E> slow = header.getNext();  // Slow pointer (moves one step at a time)
        Node<E> fast = header.getNext();  // Fast pointer (moves two steps at a time)

        // Move fast two steps and slow one step until fast reaches the end of the list
        while (fast != trailer && fast.getNext() != trailer) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    // 2. Implementation of size() method without maintaining the size instance variable
    public int sizeWithoutSizeVar() {
        int count = 0;
        Node<E> current = header.getNext();
        while (current != trailer) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // 3. Implementation of equals() method for comparing two lists
    public boolean equals(DoublyLinkedList<E> other) {
        if (this.size() != other.size()) return false;
        Node<E> thisCurrent = this.header.getNext();
        Node<E> otherCurrent = other.header.getNext();
        while (thisCurrent != this.trailer) {
            if (!thisCurrent.getElement().equals(otherCurrent.getElement())) {
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            otherCurrent = otherCurrent.getNext();
        }
        return true;
    }

    // 4. Algorithm to concatenate two doubly linked lists L and M into L'
    public static <E> void concatenate(DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        if (M.isEmpty()) return;
        L.trailer.getPrev().setNext(M.header.getNext());
        M.header.getNext().setPrev(L.trailer.getPrev());
        L.trailer = M.trailer;
        L.size += M.size();
        M.header.setNext(M.trailer);
        M.trailer.setPrev(M.header);
        M.size = 0;
    }

    // 5. Reimplement the DoublyLinkedList using only one sentinel node
    public static class DoublyLinkedListOneSentinel<E> {
        private static class Node<E> {
            private E element;
            private Node<E> prev;
            private Node<E> next;

            public Node(E element, Node<E> prev, Node<E> next) {
                this.element = element;
                this.prev = prev;
                this.next = next;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getPrev() {
                return prev;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setPrev(Node<E> prev) {
                this.prev = prev;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> sentinel;
        private int size = 0;

        public DoublyLinkedListOneSentinel() {
            sentinel = new Node<>(null, null, null);
            sentinel.setNext(sentinel);
            sentinel.setPrev(sentinel);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addFirst(E e) {
            addBetween(e, sentinel, sentinel.getNext());
        }

        public void addLast(E e) {
            addBetween(e, sentinel.getPrev(), sentinel);
        }

        private void addBetween(E e, Node<E> p, Node<E> n) {
            Node<E> x = new Node<>(e, p, n);
            p.setNext(x);
            n.setPrev(x);
            size++;
        }

        public E removeFirst() {
            if (isEmpty()) return null;
            return remove(sentinel.getNext());
        }

        public E removeLast() {
            if (isEmpty()) return null;
            return remove(sentinel.getPrev());
        }

        private E remove(Node<E> x) {
            Node<E> p = x.getPrev();
            Node<E> n = x.getNext();
            p.setNext(n);
            n.setPrev(p);
            size--;
            return x.getElement();
        }
    }

    // 6. Circular Doubly Linked List implementation
    public class CircularDoublyLinkedList<E> {
        private Node<E> head;
        private int size = 0;

        public CircularDoublyLinkedList() {
            head = null;
        }

        public void addFirst(E e) {
            Node<E> newNode = new Node<>(e, null, null);
            if (head == null) {
                head = newNode;
                head.setNext(head);
                head.setPrev(head);
            } else {
                Node<E> tail = head.getPrev();
                newNode.setNext(head);
                newNode.setPrev(tail);
                tail.setNext(newNode);
                head.setPrev(newNode);
                head = newNode;
            }
            size++;
        }

        public void rotate() {
            if (size > 1) {
                head = head.getNext();
            }
        }

        public void rotateBackward() {
            if (size > 1) {
                head = head.getPrev();
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    // 7. Implement the clone() method for the DoublyLinkedList class
    public DoublyLinkedList<E> clone() {
        DoublyLinkedList<E> clone = new DoublyLinkedList<>();
        Node<E> current = this.header.getNext();
        while (current != trailer) {
            clone.addLast(current.getElement());
            current = current.getNext();
        }
        return clone;
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Adding elements
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);
        list.addLast(30);

        // Printing list elements
        System.out.println("List after adding elements:");
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        System.out.println("Size: " + list.size());

        // Finding the middle node
        Node<Integer> middleNode = list.findMiddle();
        System.out.println("Middle node: " + middleNode.getElement());

        // Removing elements
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        // Cloning the list
        DoublyLinkedList<Integer> clonedList = list.clone();
        System.out.println("Cloned list first: " + clonedList.first());

        // Demonstrating equals method
        DoublyLinkedList<Integer> anotherList = new DoublyLinkedList<>();
    }}

