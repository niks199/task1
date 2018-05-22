class Solution {
    public String addBinary(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        
        int aPosition = a.length() - 1;
        int bPosition = b.length() - 1;
        
        String result = new String();
        
        while (aPosition >= 0 && bPosition >= 0)
        {
            char aChar = a.charAt(aPosition);
            char bChar = b.charAt(bPosition);
            
            
        }
        
        return result;
    }
}
