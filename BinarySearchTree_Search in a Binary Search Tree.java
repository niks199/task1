class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        if (root == null)
        {
            return null;
        }
        
        TreeNode retVal = null;
            
        TreeNode curNode = root;
        
        while (curNode != null)
        {
            if (val < curNode.val)
            {
                curNode = curNode.left;
            }
            else if (val > curNode.val)
            {
                curNode = curNode.right;
            }
            else
            {
                retVal = curNode;
                
                break;
            }
        }
        
        return retVal;
    }
}
