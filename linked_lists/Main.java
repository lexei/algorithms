package linked_lists;

public class Main {

    private static class SinglyLinkedListNode {

        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    /**
     * Inserts a data into single linked list
     *
     * @param head     of the list
     * @param data     to insert
     * @param position at which to insert data (starting at 0)
     * @return head of the updated list
     */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return newNode;
        }
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode ptr = head;
        for (int i = 0; i < position - 1; i++) {
            ptr = ptr.next;
        }
        SinglyLinkedListNode next = ptr.next;
        ptr.next = newNode;
        ptr.next.next = next;
        return head;
    }

    /**
     * Given pointers to the head nodes of 2 linked lists that merge together
     * at some point, find the node where the two lists merge. The merge point
     * is where both lists point to the same node, i.e. they reference the same
     * memory location. It is guaranteed that the two head nodes will be different,
     * and neither will be NULL. If the lists share a common node, return that node's data value.
     *
     * @param head1 head of first list
     * @param head2 head of second list
     * @return data in node at which they merge
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        for (SinglyLinkedListNode ptr1 = head1; ptr1 != null; ptr1 = ptr1.next) {
            for (SinglyLinkedListNode ptr2 = head2; ptr2 != null; ptr2 = ptr2.next) {
                if (ptr1 == ptr2) {
                    return ptr1.data;
                }
            }
        }
        return -1;
    }

    private static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    /**
     * Inserts data into doubly linked list at proper position to maintain sorted order
     *
     * @param llist head of the list
     * @param data to insert
     * @return head of the updated list
     */
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (llist == null) {
            return newNode;
        }
        if (data <= llist.data) {
            newNode.next = llist;
            llist.prev = newNode;
            return newNode;
        }
        DoublyLinkedListNode ptr = llist;
        while (ptr.next != null && data > ptr.next.data) {
            ptr = ptr.next;
        }
        DoublyLinkedListNode next = ptr.next;
        ptr.next = newNode;
        ptr.next.next = next;
        if (next != null) {
            next.prev = newNode;
        }
        return llist;
    }

    /**
     * Reverses list in place
     *
     * @param llist head of the list
     * @return head of the reversed list
     */
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        if (llist == null || llist.next == null) {
            return llist;
        }
        DoublyLinkedListNode newHead = reverse(llist.next);
        DoublyLinkedListNode temp = llist.next;
        temp.next = llist;
        llist.next = null;
        llist.prev = temp;
        return newHead;
    }
}
