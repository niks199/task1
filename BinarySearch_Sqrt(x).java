class Solution {
    public int mySqrt(int x) {
        
        if (x == 1)
        {
            return 1;
        }
        
        long left = 1;
        long right = x / 2;
        
        int retVal = 0;
        
        while (left <= right)
        {
            long middle = (left + right) / 2;
            
            long product = middle * middle;
            
            long productNext = (middle + 1) * (middle + 1);

            if (product == x || (product < x && productNext > x))
            {
                retVal = (int)middle;
                
                break;
            }
            else if (product > x)
            {
                right = middle - 1;
            }
            else if (product < x)
            {
                left = middle + 1;
            }
        }
        
        return retVal;
    }
}
