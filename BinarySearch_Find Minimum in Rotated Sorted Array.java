class Solution {
    public int findPivot(int[] nums, int leftIndex, int rightIndex)
    {
        if (leftIndex > rightIndex)
        {
            return -1;
        }
            
        if (leftIndex == rightIndex)
        {
            return leftIndex;
        }
        
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
        if (midIndex < rightIndex && nums[midIndex] < nums[midIndex + 1])
        {
            return midIndex;
        }
        
        if (leftIndex < midIndex && nums[midIndex - 1] > nums[midIndex])
        {
            return midIndex;
        }
        
        
        findPivot(nums, )
    }
    
    public int findMin(int[] nums)
    {
        return findPivot(nums, 0, nums.length - 1);
    }
}
