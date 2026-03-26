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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = new ListNode();
        ListNode res = head;
        while (temp1 != null && temp2 != null) {
            ListNode temp = new ListNode();
            if (temp1.val > temp2.val) {
                temp.val = temp2.val;
                temp2 = temp2.next;
            } else {
                temp.val = temp1.val;
                temp1 = temp1.next;
            }
            res.next = temp;
            res = res.next;
        }

        while(temp1 != null){
            ListNode temp = new ListNode();
            temp.val = temp1.val;
            res.next = temp;
            res = res.next;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            ListNode temp = new ListNode();
            temp.val = temp2.val;
            res.next = temp;
            res = res.next;
            temp2 = temp2.next;
        }

        return head.next;
    }
}