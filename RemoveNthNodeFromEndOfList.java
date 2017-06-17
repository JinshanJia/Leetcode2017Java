/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its 
 * head.
 * For example,
 *   Given linked list: 1->2->3->4->5, and n = 2.
 *   After removing the second node from the end, the linked list becomes 
 *   1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

class RemoveNthNodeFromEndOfList {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0) {
      return head;
    }

    int length = getLength(head);
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode previousNode = dummyHead;
    ListNode currentNode = head;
    int currentIndex = 0;
    int toRemoveIndex = length - n;
    while (currentIndex != toRemoveIndex) {
      currentIndex++;
      previousNode = currentNode;
      currentNode = currentNode.next;
    }

    previousNode.next = currentNode.next;
    return dummyHead.next;
  }

  private static int getLength(ListNode head) {
    int length = 0;
    while(head != null) {
      head = head.next;
      length++;
    }
    return length;
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      ListNode currentNode = this;
      while(currentNode != null) {
        sb.append(currentNode.val + " -> ");
        currentNode = currentNode.next;
      }
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    int i = 2;
    ListNode currentNode = a;
    while(i <= 5) {
      currentNode.next = new ListNode(i);
      currentNode = currentNode.next;
      i++;
    }

    System.out.println(removeNthFromEnd(a, 0));
  }
}