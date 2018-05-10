public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int lowNum = 1;
        int highNum = n;
        
        while (lowNum <= highNum)
        {
            int midNum = lowNum + (highNum - lowNum) / 2;
            
            int guessResult = guess(midNum);
            
            if (guessResult == 0)
            {
                return midNum;
            }
            else if (guessResult == 1)
            {
                lowNum = midNum + 1;
            }
            else if (guessResult == -1)
            {
                highNum = midNum - 1;
            }
        }
        
        return -1;
    }
}
