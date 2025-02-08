import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayBinaryTree<E> {
    private E[] tree;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public ArrayBinaryTree() {
        tree = (E[]) new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size >= tree.length) {
            tree = Arrays.copyOf(tree, tree.length * 2);
        }
    }

    public void setRoot(E value) {
        ensureCapacity();
        tree[0] = value;
        size = Math.max(size, 1);
    }

    public void setLeft(int parentIndex, E value) {
        ensureCapacity();
        int leftIndex = 2 * parentIndex + 1;
        tree[leftIndex] = value;
        size = Math.max(size, leftIndex + 1);
    }

    public void setRight(int parentIndex, E value) {
        ensureCapacity();
        int rightIndex = 2 * parentIndex + 2;
        tree[rightIndex] = value;
        size = Math.max(size, rightIndex + 1);
    }

    public E getRoot() {
        return tree[0];
    }

    public E getLeft(int parentIndex) {
        int leftIndex = 2 * parentIndex + 1;
        return tree[leftIndex];
    }

    public E getRight(int parentIndex) {
        int rightIndex = 2 * parentIndex + 2;
        return tree[rightIndex];
    }

    public void printTree() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + tree[i]);
        }
    }
}

 class ArrayList2<E> implements List<E>, Iterable<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList2() {
        this(CAPACITY);
    }

    public ArrayList2(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[current++];
        }
    }

    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        tree.setLeft(0, 2);
        tree.setRight(0, 3);
        tree.setLeft(1, 4);
        tree.setRight(1, 5);

        System.out.println("Binary Tree Representation:");
        tree.printTree();
    }
}

