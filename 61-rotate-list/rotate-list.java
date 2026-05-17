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
    public ListNode rotateRight(ListNode head, int k) {
        int i = 0;
        ListNode temp = head;
        int size = 0;

        while(temp!=null)
        {
            size++;
            temp = temp.next;
        }
        
        if(size!=0)
        {
            k = k%size;
        }
        else
        {
            return head;
        }

        if(k==0)
        {
            return head;
        }

        temp = head;

        for(i=0;i<size-k;i++)
        {
            temp = temp.next;
        }

        ListNode newhead = new ListNode(temp.val);
        ListNode temp2 = newhead;
        temp = temp.next;

        while(temp!=null)
        {
            temp2.next = new ListNode(temp.val);
            temp = temp.next;
            temp2 = temp2.next;
        }

        temp = head;

        for(i=0;i<size-k;i++)
        {
            temp2.next = new ListNode(temp.val);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newhead;
    }
}