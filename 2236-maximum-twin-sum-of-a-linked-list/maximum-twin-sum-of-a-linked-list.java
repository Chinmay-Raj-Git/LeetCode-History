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
    public int pairSum(ListNode head) {
        ListNode p1 = head;
        int n = 0;
        while(p1 != null){
            p1 = p1.next;
            n++;
        }

        ListNode p2 = head;
        ListNode temp = p2;
        for(int i=0; i<n/2; i++){
            temp = p2;
            p2 = p2.next;
        }

        // if(n==2) return p1.val+p2.val;

        ListNode prev = p2;
        ListNode cur = prev.next;
        prev.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        temp.next = prev;

        p1 = head;
        p2 = temp.next;
        int max = 0;
        while(p2 != null){
            max = Math.max(max, p1.val+p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return max;
    }
}