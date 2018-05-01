class Solution {
    public int maxDepthVal;
    
    public void maxDepthImpl(TreeNode root, int currentDepth)
    {
        if (root == null)
        {
            return;
        }
        
        System.out.println( "currentNode=" + root.val);
        
        currentDepth = currentDepth + 1;
        
        if (root.left != null)
        {
            maxDepthImpl(root.left, currentDepth);
        }
        
        if (root.right != null)
        {
            maxDepthImpl(root.right, currentDepth);
        }
        
        maxDepthVal = Math.max(maxDepthVal, currentDepth);
    }
        
    public int maxDepth(TreeNode root) {
        
        maxDepthVal = 0;
        
        maxDepthImpl(root, 0);
        
        return maxDepthVal;
    }
}
