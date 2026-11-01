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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();

            temp.next = minNode;
            temp = temp.next;

            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }

        return head.next;
    }
}
