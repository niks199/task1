public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slowIter = head;
        ListNode fastIter = head;
        
        while (slowIter != null && fastIter != null)
        {

            if (slowIter == null)
            {
                return false;
            }
            
            slowIter = slowIter.next;
            
            if (fastIter == null)
            {
                break;
            }
            
            fastIter = fastIter.next;
            
            if (fastIter == null)
            {
                break;
            }
            
            fastIter = fastIter.next;
            
            if (slowIter.equals(fastIter))
            {
                return true;
            }
        }
        
        return false;
    }
}
