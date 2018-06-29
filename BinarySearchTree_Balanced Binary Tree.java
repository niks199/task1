class Solution {

    public int height(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        
        return (1 + Math.max(height(root.left), height(root.right)));
    }
    
    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        
        int lht = height(root.left);
        int rht = height(root.right);
        
        if (Math.abs(lht - rht) <= 1 &&
           isBalanced(root.left) &&
           isBalanced(root.right))
        {
            return true;
        }
        
        return false;
    }
}
