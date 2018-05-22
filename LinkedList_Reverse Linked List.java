class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode currentHead = head;
              
        ListNode newHead = currentHead;
        
        while (currentHead !=null && currentHead.next != null)
        {
            ListNode nextNode = currentHead.next;
            
            ListNode nextOfNextNode = nextNode.next;
            
            nextNode.next = newHead;
            
            newHead = nextNode;
            
            currentHead.next = nextOfNextNode;
        }
        
        return newHead;
    }
}
