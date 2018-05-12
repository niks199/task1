class Solution {
    
    public int findCrossOver(int[] arr, int x, int left, int right )
    {
        if (x >= arr[right])
        {
            return right;
        }
        
        if (x < arr[left])
        {
            return left;
        }
        
        int mid = left + (right - left) / 2;
                
        if (arr[mid] <= x && arr[mid + 1] > x)
        {
            return mid;
        }
        
        if (arr[mid] < x)
        {
            return findCrossOver(arr, x, mid + 1, right);
        }
        
        return findCrossOver(arr, x, left, mid - 1);
    }
    
    
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> retVal = new ArrayList<>();
        
        int leftIndex = findCrossOver(arr, x, 0, arr.length - 1);
        
        int rightIndex = leftIndex + 1;
        
        int count = 0;
        
        while (leftIndex >= 0 && rightIndex < arr.length && count < k)
        {
            if (x - arr[leftIndex] <= arr[rightIndex] - x)
            {
                retVal.add(arr[leftIndex]);
                --leftIndex;
            }
            else
            {
                retVal.add(arr[rightIndex]);
                ++rightIndex;
            }
            
            count++;
        }
        
        while (count < k && leftIndex >= 0)
        {
            retVal.add(arr[leftIndex--]);
            
            count++;
        }
        
        while (count < k && rightIndex < arr.length)
        {
            retVal.add(arr[rightIndex++]);
            
            count++;
        }
        
        Collections.sort(retVal);
        
        return retVal;
    }
}
