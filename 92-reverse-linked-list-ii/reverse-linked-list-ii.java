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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftnode=null;
        ListNode rightnode=null;
        int i=1;
        ListNode temp;
        temp = head;
        while(temp!=null)
        {
            if(i==left)
            {
                leftnode = temp;
            }
            i++;
            temp = temp.next;
        }
        int tempval;
        while(left<=right)
        {
            temp = leftnode;
            for(i=left;i<right;i++)
            {
                temp = temp.next;
            }
            rightnode = temp;
            tempval = leftnode.val;
            leftnode.val = rightnode.val;
            rightnode.val = tempval;
            leftnode = leftnode.next;
            left++;
            right--;
        }
        return head;
    }
}