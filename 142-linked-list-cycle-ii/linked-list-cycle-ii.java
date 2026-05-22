/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int i = 0;
        ListNode temp = head;
        HashMap<Integer,ListNode> hash = new HashMap<>();

        if(head==null||head.next==null)
        {
            return null;
        }

        while(temp!=null)
        {
            if(hash.containsValue(temp))
            {
                for(int value : hash.keySet())
                {
                    if(hash.get(value)==temp)
                    {
                        return temp;
                    }
                }
            }
            else
            {
                hash.put(i,temp);
            }
            i++;
            temp = temp.next;
        }
        return null;
    }
}