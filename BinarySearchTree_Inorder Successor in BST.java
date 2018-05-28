class Solution {
    
    public TreeNode minElement(TreeNode root)
    {
        TreeNode curNode = root;
        
        while (curNode.left != null)
        {
            curNode = curNode.left;
        }
        
        return curNode;
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if (root == null || p == null)
        {
            return null;
        }
        
        if (p.right != null)
        {
            return minElement(p.right);
        }
             
        TreeNode succ = null;
        
        TreeNode currentNode = root;
        
        while (currentNode != null)
        {
            if (p.val < currentNode.val)
            {
                succ = currentNode;
                
                currentNode = currentNode.left;
            }
            
            else if (p.val > currentNode.val)
            {
                currentNode = currentNode.right;
            }
            else
            {
                break;
            }
        }

        return succ;
    }
}
