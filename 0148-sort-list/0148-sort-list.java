class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. Get the total length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Dummy node to help manage the head of the sorted list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Iterate by step size (1, 2, 4, 8...)
        for (int step = 1; step < length; step <<= 1) {
            ListNode prev = dummy;
            curr = dummy.next;

            while (curr != null) {
                // Split off the first sub-list (left)
                ListNode left = curr;
                ListNode right = split(left, step);
                
                // Split off the second sub-list (right) and save the remainder
                curr = split(right, step);

                // Merge left and right, then attach to the prev pointer
                prev.next = merge(left, right);
                
                // Move prev to the end of the newly merged section
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // Helper function to split off 'size' nodes and return the start of the remainder
    private ListNode split(ListNode head, int size) {
        if (head == null) return null;
        
        for (int i = 1; i < size && head.next != null; i++) {
            head = head.next;
        }

        ListNode remainder = head.next;
        head.next = null; // Cut the connection
        return remainder;
    }

    // Standard merge function for two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}