class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (k < 1 || t < 0)
        {
            return false;
        }
        
        TreeSet<Long> numSet = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            long currentNum = nums[i];
            
            if (numSet.floor(currentNum) != null && numSet.floor(currentNum) >= currentNum - t || 
                numSet.ceiling(currentNum) != null && numSet.ceiling(currentNum) <= currentNum + t)
            {
                return true;
            }
            else
            {
                numSet.add(currentNum);
                
                if (i >= k)
                {
                    numSet.remove((long)nums[i - k]);
                }
            }
        }
        
        return false;        
    }
}
