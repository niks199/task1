class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        TreeNode curNode = root;
        
        TreeNode prevNode = null;

        while (curNode != null)
        {
            prevNode = curNode;
            
            if (val < curNode.val)
            {
                curNode = curNode.left;
            }
            else if (val > curNode.val)
            {
                curNode = curNode.right;
            }
        }
        
        TreeNode retVal = null;
        
        if (prevNode != null)
        {
            if (val > prevNode.val)
            {   
                prevNode.right = new TreeNode(val);
            }
            else
            {
                prevNode.left = new TreeNode(val);
            }
            
            retVal = root;
        }
        else
        {
             retVal = new TreeNode(val);
        }
        
        return retVal;
    }
}
