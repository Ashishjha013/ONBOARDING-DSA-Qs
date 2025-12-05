public class Question6 {
  static class MyLinkedList {
    // Node structure for Doubly Linked List
    private class ListNode {
      int val;
      ListNode next;
      ListNode prev;

      ListNode(int val) {
        this.val = val;
      }
    }

    private ListNode head; // Dummy head
    private ListNode tail; // Dummy tail
    private int size; // Stores length of list

    // Constructor: creates an empty doubly linked list with dummy boundary nodes
    public MyLinkedList() {
      head = new ListNode(0);
      tail = new ListNode(0);

      head.next = tail;
      tail.prev = head;

      size = 0;
    }

    // Fetch value at a given index in O(n/2) time by choosing best direction
    public int get(int index) {
      if (index < 0 || index >= size)
        return -1;

      ListNode curr;

      // If index is closer to head, move forward
      if (index < size - index) {
        curr = head.next;
        for (int i = 0; i < index; i++) {
          curr = curr.next;
        }
      }
      // Otherwise, move backward from tail for efficiency
      else {
        curr = tail.prev;
        for (int i = 0; i < size - index - 1; i++) {
          curr = curr.prev;
        }
      }
      return curr.val;
    }

    // Insert a new node at the start of the list
    public void addAtHead(int val) {
      ListNode newNode = new ListNode(val);

      ListNode next = head.next;

      // Connect newNode between head and next
      head.next = newNode;
      newNode.prev = head;
      newNode.next = next;
      next.prev = newNode;

      size++;
    }

    // Insert a new node at the end of the list
    public void addAtTail(int val) {
      ListNode newNode = new ListNode(val);

      ListNode prev = tail.prev;

      // Connect newNode between prev and tail
      prev.next = newNode;
      newNode.prev = prev;
      newNode.next = tail;
      tail.prev = newNode;

      size++;
    }

    // Insert node at specific index
    public void addAtIndex(int index, int val) {
      if (index > size)
        return; // Invalid index → ignore

      if (index < 0)
        index = 0; // Normalize negative index (LeetCode rule)

      // Special-case shortcuts
      if (index == 0) {
        addAtHead(val);
        return;
      }
      if (index == size) {
        addAtTail(val);
        return;
      }

      ListNode newNode = new ListNode(val);
      ListNode curr;

      // Efficient traversal: choose nearest direction
      if (index < size - index) {
        curr = head.next;
        for (int i = 0; i < index; i++) {
          curr = curr.next;
        }
      } else {
        curr = tail.prev;
        for (int i = 0; i < size - index - 1; i++) {
          curr = curr.prev;
        }
      }

      // Insert newNode before curr
      ListNode prev = curr.prev;

      prev.next = newNode;
      newNode.prev = prev;
      newNode.next = curr;
      curr.prev = newNode;

      size++;
    }

    // Delete node at given index if valid
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= size)
        return;

      ListNode curr;

      // Choose best traversal direction
      if (index < size - index) {
        curr = head.next;
        for (int i = 0; i < index; i++) {
          curr = curr.next;
        }
      } else {
        curr = tail.prev;
        for (int i = 0; i < size - index - 1; i++) {
          curr = curr.prev;
        }
      }

      // Remove curr from list
      ListNode prev = curr.prev;
      ListNode next = curr.next;

      prev.next = next;
      next.prev = prev;

      size--;
    }
  }

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    list.addAtHead(10);
    list.addAtTail(20);
    list.addAtIndex(1, 15);
    list.deleteAtIndex(0);

    System.out.println("Value at index 0: " + list.get(0));
    System.out.println("Value at index 1: " + list.get(1));
  }
}
