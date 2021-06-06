package linked_lists;

public class CycleDetector {

    class Node {
        int data;
        Node next;
    }

    /**
     * Checks if linked list contains a cycle
     *
     * @param head of the list
     * @return true if has cycle else false
     */
    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slowPtr = head;
        Node fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr == fastPtr) {
                return true;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

        }
        return false;
    }
}
