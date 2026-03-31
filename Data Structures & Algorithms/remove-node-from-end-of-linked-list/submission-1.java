/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode calcLen = head;
        while (calcLen != null){
            calcLen = calcLen.next;
            length++;
        }
        int front = length - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < front; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
        
    }
}
