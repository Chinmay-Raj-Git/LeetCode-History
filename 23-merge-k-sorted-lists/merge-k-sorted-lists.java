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
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];

        ListNode dummy = new ListNode();
        ListNode res = dummy;

        int idx=0;
        int c=0; // to check are we going circularly continously in case of all null
        while(lists[idx] == null){
            if(c == lists.length)
                return null;
            idx = (idx+1)%lists.length;
            c++;
        }
        ListNode min = lists[idx];
        int minListId = idx;

        ListNode[] nextNode = new ListNode[lists.length];

        for(int i=0; i<lists.length; i++){
            nextNode[i] = lists[i];
        }
        
        masterloop:
        while(true){
            // if()

            for(int i=0; i<lists.length; i++){
                ListNode node = nextNode[i];
                if(node == null) continue;
                if(node.val <= min.val){
                    min = node;
                    minListId = i;
                    // System.out.println(node.val + " " + min.val + " " + minListId);
                }

            }
            ListNode newNode = new ListNode();
            newNode.val = min.val;
            res.next = newNode;
            res = newNode;
            nextNode[minListId]  = nextNode[minListId].next;
            int count=0; // to check are we going circularly continously in case of all null
            while(nextNode[minListId] == null){
                if(count == lists.length)
                    break masterloop;
                minListId = (minListId+1)%lists.length;
                count++;
            }
            min = nextNode[minListId];

            //printing res list
            // ListNode t = dummy.next;
            // while(t!=null){
            //     System.out.print(t.val + ", ");
            //     t = t.next;
            // }
            // System.out.println("\n--");
        }
        

        return dummy.next;

    }
}