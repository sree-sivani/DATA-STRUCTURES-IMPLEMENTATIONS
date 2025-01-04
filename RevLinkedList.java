/**
 * Linked List Implementation in Java
 * 
 * This code implements a basic singly linked list with functionality for adding
 * elements to the front or back, deleting elements from the front or back, displaying
 * the list, reversing the list, and retrieving its size.
 */

class LL {
    /**
     * Tracks the size of the linked list.
     */
    private int size;

    /**
     * Points to the head (first node) of the linked list.
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
        /** Stores the data of the node. */
        String data;
        /** Points to the next node in the list. */
        Node next;

        /**
         * Constructor initializes the node with given data and sets the next pointer to null.
         * 
         * @param data Data to be stored in the node.
         */
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a new node with the given data at the beginning of the list.
     * 
     * @param data Data to be added.
     */
    public void addFirst(String data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Point new node to current head
        head = newNode; // Update head to the new node
        size++; // Increase the size count
    }

    /**
     * Adds a new node with the given data at the end of the list.
     * 
     * @param data Data to be added.
     */
    public void addLast(String data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) { // If list is empty, set new node as head
            head = newNode;
            return;
        }
        
        Node currNode = head;
        while (currNode.next != null) { // Traverse to the last node
            currNode = currNode.next;
        }
        
        currNode.next = newNode; // Set last node's next to the new node
        size++; // Increase the size count
    }

    /**
     * Displays all the elements in the linked list.
     */
    public void displayList() {
        Node currNode = head;
        while (currNode != null) { // Traverse through the list
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL"); // End of the list
    }

    /**
     * Deletes the first node in the list.
     * Prints a message if the list is empty.
     */
    public void delFirst() {
        if (head == null) { // Check if list is empty
            System.out.println("Empty List");
            return;
        }
        
        head = head.next; // Move head to the next node
        size--; // Decrease the size count
    }

    /**
     * Deletes the last node in the list.
     * Prints a message if the list is empty.
     */
    public void delLast() {
        if (head == null) { // Check if list is empty
            System.out.println("Empty List");
            return;
        }

        if (head.next == null) { // If only one node exists
            head = null;
            return;
        }

        Node currNode = head;
        Node prevNode = null;
        while (currNode.next != null) { // Traverse to the last node
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        prevNode.next = null; // Remove last node
        size--; // Decrease the size count
    }

    /**
     * Retrieves the size of the linked list.
     * 
     * @return The number of elements in the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Reverses the linked list.
     */
    public void reverseList() {
        if (head == null || head.next == null) { // If list is empty or has one element
            return;
        }

        Node prevNode = null;
        Node currNode = head;
        Node nextNode;

        while (currNode != null) { // Traverse the list
            nextNode = currNode.next; // Store next node
            currNode.next = prevNode; // Reverse the link
            prevNode = currNode; // Move previous node forward
            currNode = nextNode; // Move current node forward
        }

        head = prevNode; // Update head to the last node (now the first node)
        displayList(); // Display reversed list
    }
}

/**
 * Main class to demonstrate the functionality of the linked list.
 */
public class RevLinkedList {
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

        // Adding more elements
        l.addFirst("O");
        l.addFirst("N");
        l.addFirst("M");

        // Reversing the linked list
        l.reverseList(); // Output: O -> N -> M -> B -> C -> NULL
    }
}
