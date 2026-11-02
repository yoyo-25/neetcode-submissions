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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        
        int n = 0;
        ListNode temp = head;

        while(temp != null){
            n++;
            temp = temp.next;
        }

        temp = head;
        ListNode prev = null;
        ListNode prevTail = null;
        ListNode newHead = null;
        ListNode safeNode;
        int j = k;

        while(temp != null && j > 0){
            safeNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = safeNode;
            j--;
        }

        prevTail = head;
        head = prev;

        for(int i=0; i<(n/k)-1; i++){
            newHead = temp;
            j=k;

            while(temp != null && j>0){
                safeNode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = safeNode;
                j--;
            }

            prevTail.next = prev;
            prevTail = newHead;
        }

        prevTail.next = temp;

        return head;
    }
}
