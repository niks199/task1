public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        if (n == 1)
        {
            return n;
        }
        
        int low = 1;
        int high = n;
        
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            
            boolean isBadMid = isBadVersion(mid);
            boolean isBadMidPlus = isBadVersion(mid + 1);

            if (!isBadMid && isBadMidPlus)
            {
                return mid + 1;
            }
            
            if (isBadMid && isBadMidPlus)
            {
                high = mid;
            }
            else if (!isBadMid && !isBadMidPlus)
            {
                low = mid;
            }
        }
        
        boolean isBadLow = isBadVersion(low);
        
        if(low != n && isBadLow) return low;
        
        return n;
    }
}
