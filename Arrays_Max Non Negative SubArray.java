public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        
        ArrayList<Integer> retVal = new ArrayList<>();
        
        int startIndex = -1;
        int endIndex = -1;
        
        ArrayList<Integer> candidateVal = new ArrayList<>();
        
        for (int i = 0; i < A.size(); ++i)
        {
            if ( A.get(i) < 0 )
            {
                if (retVal.isEmpty())
                {
                    retVal = new ArrayList<Integer>(candidateVal);
                }
                else
                {
                    long sum1 = 0;
                    
                    for (int k = 0; k < retVal.size(); ++k)
                    {
                        sum1 += retVal.get(k);
                    }

                    long sum2 = 0;
                    
                    for (int k = 0; k < candidateVal.size(); ++k)
                    {
                        sum2 += candidateVal.get(k);
                    }
                    
                    if (sum2 > sum1)
                    {
                        retVal = new ArrayList<Integer>(candidateVal);
                    }
                }
                
                candidateVal.clear();
            }
            else
            {
                candidateVal.add(A.get(i));
            }
        }
        
        if (!candidateVal.isEmpty())
        {
                    long sum1 = 0;
                    
                    for (int k = 0; k < retVal.size(); ++k)
                    {
                        sum1 += retVal.get(k);
                    }

                    long sum2 = 0;
                    
                    for (int k = 0; k < candidateVal.size(); ++k)
                    {
                        sum2 += candidateVal.get(k);
                    }
                    
                    if (sum2 > sum1)
                    {
                        retVal = new ArrayList<Integer>(candidateVal);
                    }
            
        }
        
        return retVal;
    }
}
