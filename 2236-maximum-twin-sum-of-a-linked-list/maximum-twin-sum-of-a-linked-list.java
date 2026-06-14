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
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        temp = head;
        for(int i=0; i<n; i++){
            map.put(i, temp.val);
            temp = temp.next;
        }

        int maxSum = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int me = e.getKey();
            if(me > (n/2)) break;

            int twin = n-1-me;

            maxSum = Math.max(maxSum, map.get(me)+map.get(twin));
        }


        return maxSum;
    }
}