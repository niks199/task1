class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode targetNode = null;
        
        TreeNode curNode = root;
        TreeNode prevNode = null;
        
        while (curNode != null)
        {
            if (key > curNode.val)
            {
                prevNode = curNode;
                
                curNode = curNode.right;
            }
            else if (key < curNode.val)
            {
                prevNode = curNode;
                
                curNode = curNode.left;
            }
            else
            {
                targetNode = curNode;
                
                break;
            }
        }
        
        if (targetNode == null)
        {
            return root;
        }
        
        if (targetNode.left == null && targetNode.right == null)
        {
            if (prevNode != null)
            {
                if (prevNode.left == targetNode)
                {
                    prevNode.left = null;
                }
                else if (prevNode.right == targetNode)
                {
                    prevNode.right = null;
                }
                else
                {
                    root = null;
                }
            }
        }
        else if (targetNode.left != null && targetNode.right != null)    
        {
        }
        
        /*
        else if (targetNode.left != null && targetNode.right != null)    
        {
            TreeNode interNode = targetNode.right;
            
            TreeNode prevInterNode = null;
                
            while (interNode.left != null)
            {
                prevInterNode = interNode;
                
                interNode = interNode.left;
            }
            
            if (interNode != null)
            {
                targetNode.val = interNode.val;
                
                if (prevInterNode != null)
                {
                    prevInterNode.left = null;
                }
                else
                {
                    targetNode.right = null;
                }
            }
        }
        else if (targetNode.left != null || targetNode.right != null)
        {
            if (prevNode != null && prevNode.left == targetNode)
            {
                prevNode.left = (targetNode.left != null ? targetNode.left : targetNode.right);
            }
            else if (prevNode != null && prevNode.right == targetNode)
            {
                prevNode.right = (targetNode.left != null ? targetNode.left : targetNode.right);
            }
            else if (prevNode == null)
            {
                return (targetNode.left != null ? targetNode.left : targetNode.right);
            }
        }
        */
        
        return root;
    }
  

}
