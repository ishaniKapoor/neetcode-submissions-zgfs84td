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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        
        for (int i = 1; i < lists.length; i++){
            lists[i] = mergedHelper(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergedHelper(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;

            if (l2 != null){
                res.next = l2;
            } else {
                res.next = l1;
            }
        }
        return dummy.next;
    }
}
