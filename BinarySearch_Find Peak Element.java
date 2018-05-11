class Solution {
    
    public int getElementValue(int[] nums, int index)
    {
        if (index == -1 || index == nums.length)
        {
            return Integer.MIN_VALUE;
        }
        
        return nums[index];
    }
    
    public int findPeakElementImpl(int[] nums, int leftIndex,  int rightIndex)
    {
        if (leftIndex >  rightIndex)
        {
            return -1;
        }
        
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            
        System.out.println("midIndex=" + midIndex + " leftIndex=" + leftIndex + " rightIndex=" + rightIndex);
        
        if (getElementValue(nums, midIndex) > getElementValue(nums, midIndex + 1) && 
            getElementValue(nums, midIndex) > getElementValue(nums, midIndex - 1) )
        {
            return midIndex;
        }
        
        int peakIndex = findPeakElementImpl(nums, leftIndex, midIndex - 1);
        
        if (peakIndex == -1)
        {
            peakIndex = findPeakElementImpl(nums, midIndex + 1, rightIndex);

        }
        
        return peakIndex;
    }
    
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1)
        {
            return 0;
        }
        
        return findPeakElementImpl(nums, 0, nums.length - 1);
    }
}
