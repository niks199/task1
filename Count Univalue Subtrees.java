class Solution {
    
    int count = 0;
    
    //Integer.MIN_VALUE -- Mark the subtree is not univaled. 
    //Integer.MAX_VALUE -- Mark if the root is null. 
    
    public int countUnivalSubtreesImpl(TreeNode root)
    {
        if (root == null)
        {
            return Integer.MAX_VALUE;
        }
        
        int leftVal = countUnivalSubtreesImpl(root.left);
        int rightVal = countUnivalSubtreesImpl(root.right);
        
        if (leftVal == Integer.MAX_VALUE && rightVal == Integer.MAX_VALUE)
        {
            count++;
            
            return root.val;
        }
        else if (leftVal == Integer.MAX_VALUE || rightVal == Integer.MAX_VALUE)
        {
            if (root.val == leftVal || root.val == rightVal)
            {
                count++;
                
                return root.val;
            }
            else
            {
                return Integer.MIN_VALUE;
            }
        }   
        else
        {
            if (root.val == leftVal && root.val == rightVal)
            {
                count++;
                
                return root.val;
            }
            else
            {
                return Integer.MIN_VALUE;
            }
        }
    }
    
    public int countUnivalSubtrees(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
            
        count = 0;
        
        countUnivalSubtreesImpl(root);
        
        return count;
    }
}
