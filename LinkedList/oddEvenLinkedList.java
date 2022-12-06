// https://leetcode.com/problems/odd-even-linked-list/

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode temp = head.next.next;

        boolean isOddFlag = true;
        while(temp!= null){
            if(isOddFlag){
                isOddFlag = false;
                odd.next = temp;
                odd = odd.next;
                even.next = null;
            }
            else{
                isOddFlag = true;
                even.next = temp;
                even = even.next;
                odd.next = null;
            }
            temp = temp.next;
        }
        odd.next = evenHead;
        return head;
    }
}
