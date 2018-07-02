public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        
        int maxSum;
        
        int pendingSum = A.get(0);
        
        maxSum = pendingSum;
        
        for (int i = 1; i < A.size(); ++i)
        {
            pendingSum = Math.max(pendingSum + A.get(i), A.get(i));
            
            maxSum = Math.max(maxSum, pendingSum);
        }

        return maxSum;
    }
}
