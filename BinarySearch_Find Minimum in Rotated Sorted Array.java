class Solution {
    
public int findPivot(int[] nums, int leftIndex, int rightIndex)
    {
        if (leftIndex > rightIndex)
        {
            return 0;
        }
            
        if (leftIndex == rightIndex)
        {
            return leftIndex;
        }
        
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
        if (midIndex < rightIndex && nums[midIndex] > nums[midIndex + 1])
        {
            return midIndex + 1;
        }
        
        if (leftIndex < midIndex && nums[midIndex - 1] > nums[midIndex])
        {
            return midIndex;
        }
        
        if (nums[rightIndex] >= nums[midIndex])
        {
            return findPivot(nums, leftIndex, midIndex - 1);
        }
    
        return findPivot(nums, midIndex + 1, rightIndex);
    }
    
    public int findMin(int[] nums)
    {
        return nums[findPivot(nums, 0, nums.length - 1)];
    }
}
