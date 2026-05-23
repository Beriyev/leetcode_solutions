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
        ArrayList<Integer> arraylist = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            arraylist.add(temp.val);
            temp = temp.next;
        }
        Integer[] arr = arraylist.toArray(new Integer[0]);
        Arrays.sort(arr);
        temp = head;
        int i = 0;
        while(temp!=null)
        {
            temp.val = arr[i];
            i++;
            temp = temp.next;
        }
        return head;
    }
}