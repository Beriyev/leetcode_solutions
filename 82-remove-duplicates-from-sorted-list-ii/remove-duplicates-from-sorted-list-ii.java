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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast;
        ListNode prev;
        ListNode curr;

        if(head==null || head.next==null)
        {
            return head;
        }

        if(head.val==head.next.val)
        {
            curr = head;
            while(curr!=null&&curr.val==head.val)
            {
                curr = curr.next;
            }
            head = curr;
            if(head==null||head.next==null)
            {
                return head;
            }
        }

        prev = null;
        curr = head;

        while(curr!=null)
        {
            if(curr.next!=null&&curr.val==curr.next.val)
            {
                fast = curr.next;
                while(fast!=null&&curr.val==fast.val)
                {
                    fast = fast.next;
                }
                if(prev!=null)
                {
                    prev.next = fast;
                }
                else
                {
                    head = fast;
                }
                curr = fast;
            }
            else
            {
                if(prev==null)
                {
                    prev = curr;
                }
                else
                    prev = prev.next;

                curr = curr.next;
            }
        }

        return head;
    }
}