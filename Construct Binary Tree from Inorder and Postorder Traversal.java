class Solution {
    
    public TreeNode constructTreeFromInOrderAndPostOrder(int inOrderStart, int inOrderEnd, int[] inorder,
                                                        int postOrderStart, int postOrderEnd, int[] postorder)
    {
        if(postOrderStart > postOrderEnd)
        {
            return null;
        }
            
        int rootVal = postorder[postOrderEnd];
        
        
        int rootInorderPos=0;
    
        for (int i = inOrderStart; i <= inOrderEnd; i++)
        {
            if(rootVal==inorder[i])
            {
                rootInorderPos = i;
                
                break;
            }  
        }
        

        TreeNode node = new TreeNode(rootVal);
                
        int numberOfNodes = rootInorderPos - inOrderStart;
        
        node.left = constructTreeFromInOrderAndPostOrder(inOrderStart, rootInorderPos - 1, inorder,
                                                        postOrderStart, postOrderStart + numberOfNodes - 1, postorder);
        node.right = constructTreeFromInOrderAndPostOrder(rootInorderPos + 1, inOrderEnd, inorder,
                                                        postOrderStart + numberOfNodes, postOrderEnd - 1, postorder);
        
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return constructTreeFromInOrderAndPostOrder(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
 
    }
}
