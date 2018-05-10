class Solution {
    
    public int findInSorted(int[] nums, int lowIndex, int highIndex, int target)
    {
        if (highIndex < lowIndex)
        {
            return -1;
        }
        
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        
        if (target == nums[midIndex])
        {
            return midIndex;
        }
        
        if (target > nums[midIndex])
        {
            return findInSorted(nums, (midIndex + 1), highIndex, target);
        }
        
        return findInSorted(nums, lowIndex, (midIndex -1), target);
    }
    
    public int findPivot(int[] nums, int lowIndex, int highIndex)
    {
        if (lowIndex > highIndex)
        {
            return -1;
        }
        
        if (lowIndex == highIndex)
        {
            return lowIndex;
        }
        
        int midIndex = (lowIndex + highIndex) / 2;
        
        if (midIndex < highIndex && nums[midIndex] > nums[midIndex + 1])
        {
            return midIndex;
        }
        
        if (lowIndex < midIndex && nums[midIndex - 1] > nums[midIndex])
        {
            return midIndex - 1;
        }
        
        if (nums[lowIndex] >= nums[midIndex])
        {
            return findPivot(nums, lowIndex, midIndex - 1);
        }
        
        return findPivot(nums, midIndex + 1, highIndex);
    }
    
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        
        int pivotIndex = findPivot(nums, 0, nums.length - 1);
        
        if (pivotIndex == -1)
        {
            return findInSorted(nums, 0, nums.length - 1, target);
        }
        
        if (nums[pivotIndex] == target)
        {
            return pivotIndex;
        }
        
        if (nums[0] <= target)
        {
            return findInSorted(nums, 0, pivotIndex - 1, target);
        }
        
        return findInSorted(nums, pivotIndex + 1, nums.length - 1, target);
    }
}
