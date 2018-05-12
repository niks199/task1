class Solution {
    
    public int searchArr(ArrayReader reader, int target, int leftIndex, int rightIndex)
    {
        while (leftIndex < rightIndex)
        {
            int leftElem = reader.get(leftIndex);
            int rightElem = reader.get(rightIndex);
        
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
            System.out.println("leftIndex=" + leftIndex + " rightIndex=" + rightIndex + " midIndex=" + midIndex);
            
            int midElem = reader.get(midIndex);
        
            System.out.println("leftElem=" + leftElem + " rightElem=" + rightElem + " midElem=" + midElem);
            
            if (midElem == target)
            {
                return midIndex;
            }
            else if (target > midElem)
            {
                leftIndex = midIndex + 1;
            }
            else if (target < midElem )
            {
                rightIndex = midIndex - 1;
            }
        }
        
        if (rightIndex == leftIndex && reader.get(leftIndex) == target)
        {
            return leftIndex;
        }
        
        return -1;
    }
    
    public int search(ArrayReader reader, int target) {
        
        int leftIndex = 0;
        int rightIndex = 1;
        
        int rightVal = reader.get(leftIndex);
        
        if (rightVal == 2147483647)
        {
            return -1;
        }

        System.out.println("rightVal=" + rightVal + " target=" + target);
        
        while (rightVal < target && rightVal != 2147483647)
        {            
            leftIndex = rightIndex;
            rightIndex = rightIndex * 2;
            
            System.out.println("leftIndex=" + leftIndex + " rightIndex=" + rightIndex);
                
            rightVal = reader.get(rightIndex);
        }
            
        if (rightVal == 2147483647)
        {
            return -1;
        }
        
        int result = searchArr(reader, target, leftIndex, rightIndex);

        return result;
    }
}
