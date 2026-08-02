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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        int i;

        for(i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.offer(lists[i]);
            }
        }

        ListNode head = null;
        int headFound = 0;

        ListNode curr = null;
        ListNode current = null;

        while(!pq.isEmpty())
        {
            curr = pq.poll();

            if(headFound==0)
            {
                head = new ListNode(curr.val);
                headFound = 1;
                current = head;
            }
            else
            {
                current.next = new ListNode(curr.val);
                current = current.next;
            }

            curr = curr.next;

            if(curr!=null)
            {
                pq.offer(curr);
            }
        }
        return head;
    }
}