class Solution {
    
    public TreeNode constructTree(int startPreorderIndex, int stopPreorderIndex, int[] preorder,
                                 int startInorderIndex, int stopInorderIndex, int[] inorder)
    {
        if (startInorderIndex > stopInorderIndex)
        {
            return null;
        }
        
        int preorderVal = preorder[startPreorderIndex];
        
        int valueInorderIndex = 0;
        
        for (int i = startInorderIndex; i <= stopInorderIndex; ++i)
        {
            if (inorder[i] == preorderVal)
            {
                valueInorderIndex = i;
                
                break;
            }
        }
        
        int numItems = valueInorderIndex - startInorderIndex;
        
        TreeNode node = new TreeNode(preorderVal);
        
        node.left = constructTree(startPreorderIndex + 1, startPreorderIndex + numItems + 1, preorder,
                                  startInorderIndex, valueInorderIndex - 1, inorder);
        
        node.right = constructTree(startPreorderIndex + 1 + numItems, stopPreorderIndex, preorder,
                                  valueInorderIndex + 1, stopInorderIndex, inorder);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }
}
