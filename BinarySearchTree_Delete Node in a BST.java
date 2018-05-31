class Solution {
    
    public TreeNode findSuccessor(TreeNode root)
    {
        TreeNode curNode = root.right;
        
        while (curNode != null && curNode.left != null)
        {
            curNode = curNode.left;
        }
        
        return curNode;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null)
        {
            return null;
        }
        
        if (key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        else
        {
            if (root.left == null)
            {
                return root.right;
            }
            
            if (root.right == null)
            {
                return root.left;
            }
            
            TreeNode successor = findSuccessor(root);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        
        return root;
    }
}
