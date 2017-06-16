/**
 *  2. Add Two Numbers
 *  You are given two non-empty linked lists representing two non-negative 
 *  integers. The digits are stored in reverse order and each of their nodes 
 *  contain a single digit. Add the two numbers and return it as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the 
 *  number 0 itself.
 *  
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 */

class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummyHead = new ListNode(0);
    ListNode currentResultNode = dummyHead;
    while(l1 != null || l2 != null || carry != 0) {
      int currentNodeValue = carry;
      if (l1 != null) {
        currentNodeValue += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        currentNodeValue += l2.val;
        l2 = l2.next;
      }
      carry = currentNodeValue / 10;
      currentNodeValue %= 10;
      currentResultNode.next = new ListNode(currentNodeValue);
      currentResultNode = currentResultNode.next;
    }
    return dummyHead.next;
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
    ListNode a = new ListNode(0);

    ListNode b = new ListNode(0);
    System.out.println(addTwoNumbers(a, b));
  }
}