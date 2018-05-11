class Solution {
    
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] positionList = new int[2];
        
        positionList[0] = -1;
        positionList[1] = -1;
        
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        
        while (leftIndex <= rightIndex)
        {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            
            if (nums[midIndex] == target)
            {
                positionList[0] = midIndex;
                positionList[1] = midIndex;
                
                int lookupIndex = midIndex;
                
                while (lookupIndex >= 0)
                {
                    if (nums[lookupIndex] == target)
                    {
                        positionList[0] = lookupIndex;
                    }
                    else
                    {
                        break;
                    }
                    
                    --lookupIndex;
                }
                
                lookupIndex = midIndex;
                
                while (lookupIndex < nums.length)
                {
                    if (nums[lookupIndex] == target)
                    {
                        positionList[1] = lookupIndex;
                    }
                    else
                    {
                        break;
                    }

                    lookupIndex++;
                }
                
                break;
            }
            else if (nums[midIndex] < target)
            {
               leftIndex =  midIndex + 1;
            }
            else if (nums[midIndex] > target)
            {
                rightIndex = midIndex - 1;
            }
        }
        
        return positionList;
    }
}
