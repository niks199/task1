class Solution {
    public double bs(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        
        double retVal = bs(x, n / 2);

        if ((n & 1) != 0)
        {
            return retVal * retVal * x;
        }
        
        return retVal * retVal;
    }
    
    public double myPow(double x, int n) {
        int nn = n;
        
        if (n < 0)
        {
            nn = Math.abs(n); 
        }
        
        double retVal = bs(x, nn);
        
        if (n < 0)
        {
            retVal = 1 / retVal;
        }
        
        return retVal;
    }
}
