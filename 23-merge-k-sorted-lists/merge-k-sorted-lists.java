class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (true) {
            int minIndex = -1;

            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue;

                if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                    minIndex = i;
                }
            }

            if (minIndex == -1) break;

            tail.next = lists[minIndex];
            tail = tail.next;

            lists[minIndex] = lists[minIndex].next;
        }

        return dummy.next;
    }
}