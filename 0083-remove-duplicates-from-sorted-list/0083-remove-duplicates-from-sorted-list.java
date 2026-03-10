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
        Set<Integer> set = new TreeSet<>();
        ListNode current = head;
        while(current != null) {
            set.add(current.val);
            current = current.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode top = dummy;
        for(int value : set) {
            top.next = new ListNode(value);
            top = top.next;
        }
        return dummy.next;
    }
}
