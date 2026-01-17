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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return ;
        
        ListNode curr = head;
        ListNode middle = middleEle(curr);
    
        ListNode newHead = reverse(middle.next);
        middle.next = null;
        
        

        curr = head ;
        ListNode curr2 = newHead;

       while (curr2 != null) {
    ListNode temp1 = curr.next;
    ListNode temp2 = curr2.next;

    curr.next = curr2;
    curr2.next = temp1;

    curr = temp1;
    curr2 = temp2;
}

    



    }

    private static ListNode middleEle(ListNode head){
        
        ListNode slow = head ;
        ListNode fast = head;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private static ListNode reverse(ListNode head){

       
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

    
}