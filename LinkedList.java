/**
 * Linked List Implementation in Java
 * 
 * This code implements a basic singly linked list with functionality for adding elements
 * to the front or back, deleting elements from the front or back, displaying the list,
 * and retrieving its size.
 */

class LL {
    /**
     * Tracks the size of the linked list.
     */
    private int size;

    /**
     * Points to the head node of the linked list.
     */
    Node head;

    /**
     * Constructor initializes the size of the list to zero.
     */
    LL() {
        size = 0;
    }

    /**
     * Node class represents each element of the linked list.
     */
    class Node {
        /**
         * Stores the data of the node.
         */
        String data;

        /**
         * Points to the next node in the list.
         */
        Node next;

        /**
         * Constructor initializes the node with given data and sets the next node to null.
         * @param data Data to be stored in the node.
         */
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a new node with the given data at the beginning of the list.
     * @param data Data to be added.
     */
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds a new node with the given data at the end of the list.
     * @param data Data to be added.
     */
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
        size++;
    }

    /**
     * Displays all the elements in the linked list.
     */
    public void displayList() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ->");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    /**
     * Deletes the first node in the list.
     * Prints a message if the list is empty.
     */
    public void delFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        head = head.next;
        size--;
    }

    /**
     * Deletes the last node in the list.
     * Prints a message if the list is empty.
     */
    public void delLast() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node currNode = head;
        Node prevNode = head;
        while (currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        prevNode.next = null;
        size--;
    }

    /**
     * Retrieves the size of the linked list.
     * @return The number of elements in the list.
     */
    public int getSize() {
        return size;
    }
}

/**
 * Main class to demonstrate the functionality of the linked list.
 */
public class LinkedList {
    public static void main(String[] args) {
        LL l = new LL();

        // Adding elements to the beginning of the list
        l.addFirst("C");
        l.addFirst("B");
        l.addFirst("A");
        l.displayList(); // Output: A -> B -> C -> NULL
        System.out.println(l.getSize()); // Output: 3

        // Adding an element to the end of the list
        l.addLast("D");
        l.displayList(); // Output: A -> B -> C -> D -> NULL
        System.out.println(l.getSize()); // Output: 4

        // Deleting the first element
        l.delFirst();
        l.displayList(); // Output: B -> C -> D -> NULL
        System.out.println(l.getSize()); // Output: 3

        // Deleting the last element
        l.delLast();
        l.displayList(); // Output: B -> C -> NULL
        System.out.println(l.getSize()); // Output: 2
    }
}
