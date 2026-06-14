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
        ListNode prevnode;
        ListNode nextnode;
        ListNode currnode;
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid;

        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        currnode = slow;
        nextnode = currnode.next;
        prevnode = null;

        while(currnode!=null)
        {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }

        mid = prevnode;
        int max = 0;
        ListNode temp = head;
        while(mid!=null)
        {
            if(temp.val+mid.val>max)
            {
                max = temp.val+mid.val;
            }
            temp = temp.next;
            mid = mid.next;
        }

        return max;
    }
}