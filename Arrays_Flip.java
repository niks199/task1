public class Solution {
    public ArrayList<Integer> flip(String A) {
        
        List<Integer> Ai = new ArrayList<>();
        
        boolean hasZeros = false;
        
        for (int i = 0; i < A.length(); ++i)
        {
            if (A.charAt(i) == '0')
            {
                Ai.add(1);
                
                hasZeros = true;
            }
            else if (A.charAt(i) == '1')
            {
                Ai.add(-1);
            }
        }
        
        if (!hasZeros)
        {
            return new ArrayList<Integer>();
        }
        
        int maxEndingHere = 0;
        int maxSumSoFar = 0;
        
        int Lpending = 0;
        int Rpending = 0;

        int Lmax = 0;
        int Rmax = 0;
        
        for (int i = 0; i < Ai.size(); ++i)
        {
            if (maxEndingHere + Ai.get(i) < 0)
            {
                maxEndingHere = 0;
                Lpending = i + 1;
            }
            else
            {
                maxEndingHere += Ai.get(i);
            }
            
            if (maxEndingHere > maxSumSoFar)
            {
                maxSumSoFar = maxEndingHere;
                
                Lmax = Lpending;
                Rmax = i;
            }
        }
        
        ArrayList<Integer> retVal = new ArrayList<Integer>();
        
        retVal.add(Lmax + 1);
        retVal.add(Rmax + 1);
        
        return retVal;
    }
}
