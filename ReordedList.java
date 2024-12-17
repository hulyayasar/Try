public class ReordedList {

    /*
 The positions of a linked list of length = 7 for example, can intially be represented as:
[0, 1, 2, 3, 4, 5, 6]
Reorder the nodes of the linked list to be in the following order:
[0, 6, 1, 5, 2, 4, 3]
Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
[0, n-1, 1, n-2, 2, n-3, ...]
You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
     */


     //first i will solve it recursively
    public static void reorderList_1(ListNode head) {
        if(head != null) 
        recursion(head, head.next);
    }

    public static ListNode recursion(ListNode start, ListNode curr){

        if(curr == null){ return start;}

        start = recursion(start, curr.next);

        if(start == null){ return null; }

        ListNode tmp = null;

        if(start==curr || start.next == curr){
            curr.next = null;
        }else{
            tmp = start.next;
            start.next = curr;
            curr.next = tmp;
        }
        return tmp;
    }

    //now lets try to solve it iteratively without creating too much pointer
    //how i will approach this problem is that i will 

    public static void reorderList(ListNode head) {

        if(head == null) return;
        ListNode first = head;
  
        //first find the second half of list
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while(second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        while(prev != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = prev.next;

            first.next = prev;
            prev.next = tmp1;
            first = tmp1;
            prev = tmp2;
        }
    }


    

            public static void main(String[] args) {
            // Test Case 1: Even number of nodes
            ListNode head1 = createLinkedList(new int[]{2, 4, 6, 8});
            System.out.println("Original List: " + listToString(head1));
            new ReordedList();
            ReordedList.reorderList(head1);
            System.out.println("Reordered List: " + listToString(head1));
    
            // Test Case 2: Odd number of nodes
            ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5});
            System.out.println("Original List: " + listToString(head2));
            new ReordedList();
            ReordedList.reorderList(head2);
            System.out.println("Reordered List: " + listToString(head2));
    
            // Test Case 3: Single node
            ListNode head3 = createLinkedList(new int[]{1});
            System.out.println("Original List: " + listToString(head3));
            new ReordedList();
            ReordedList.reorderList(head3);
            System.out.println("Reordered List: " + listToString(head3));
    
            // Test Case 4: Two nodes
            ListNode head4 = createLinkedList(new int[]{1, 2});
            System.out.println("Original List: " + listToString(head4));
            new ReordedList();
            ReordedList.reorderList(head4);
            System.out.println("Reordered List: " + listToString(head4));
    
            // Test Case 5: Empty list
            ListNode head5 = createLinkedList(new int[]{});
            System.out.println("Original List: " + listToString(head5));
            new ReordedList();
            ReordedList.reorderList(head5);
            System.out.println("Reordered List: " + listToString(head5));
        }
    
        // Helper method to create a linked list from an array
        public static ListNode createLinkedList(int[] values) {
            if (values.length == 0) return null;
            ListNode head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }
            return head;
        }
    
        // Helper method to convert a linked list to a string representation
        public static String listToString(ListNode head) {
            StringBuilder sb = new StringBuilder();
            ListNode current = head;
            while (current != null) {
                sb.append(current.val).append(" -> ");
                current = current.next;
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 4) : "Empty List";
        }
    
    


    
}
