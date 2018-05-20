class Solution {
    public int[] plusOne(int[] digits) {
        int digitIndex = digits.length - 1;
        
        int carryDigit = 0;
        
        while (digitIndex >= 0)
        {
            int sumResult = digits[digitIndex] + 1;
        
            if (carryDigit > 0)
            {
                sumResult = digits[digitIndex] + carryDigit;
                
                carryDigit = 0;
            }
            
            if  (sumResult > 9)
            {
                digits[digitIndex] = 0;
                
                carryDigit = 1;
                
                
            }
            else
            {
                digits[digitIndex] = sumResult;
                
                break;
            }
            
            --digitIndex;
        }
        
        if (carryDigit > 0)
        {
            int[] digitsn = new int[digits.length + 1];
            
            digitsn[0] = carryDigit;
            carryDigit = 0;
            
            for (int i = 0; i < digits.length; ++i)
            {
                digitsn[i + 1] = digits[i];
            }
            
            return digitsn;
        }
        
        return digits;
    }
}
