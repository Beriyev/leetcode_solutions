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
    public ListNode sortList(ListNode head) {

        if(head==null||head.next==null)
        {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;
        
        ListNode left = sortList(first);
        ListNode right = sortList(second);

        return merge(left,right);
    }

    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode temphead = new ListNode(0);
        ListNode temp = temphead;

        while(left!=null&&right!=null)
        {
            if(left.val<=right.val)
            {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else if(right.val<=left.val)
            {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        if(left==null)
        {
            while(right!=null)
            {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        if(right==null)
        {
            while(left!=null)
            {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
        }

        return temphead.next;
    }
}