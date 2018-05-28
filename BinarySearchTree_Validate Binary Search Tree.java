class Solution {
    Integer minVal;
    boolean isMinValInit;
    
    public boolean isValidBSTImpl(TreeNode root) {
        
        if (root.left != null)
        {
            if (!isValidBSTImpl(root.left))
            {
                return false;
            }
        }
        
        if (!isMinValInit)
        {
            minVal = root.val;
            
            isMinValInit = true;
        }
        else if (minVal < root.val)
        {
            minVal = root.val;
        }
        else if (minVal >= root.val)
        {
            return false;
        }
        
        if (root.right != null)
        {
            if (!isValidBSTImpl(root.right))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {

        if (root == null)
        {
            return true;
        }

        isMinValInit = false;
            
        return isValidBSTImpl(root);
    }
}
