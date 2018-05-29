public class BSTIterator {

    Stack<TreeNode> m_pathStack;
    
    public BSTIterator(TreeNode root)
    {
        m_pathStack = new Stack<>();
        
        TreeNode curNode = root;
        
        while (curNode != null)
        {
            m_pathStack.push(curNode);
            curNode = curNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext()
    {
        return !m_pathStack.empty();
    }

    /** @return the next smallest number */
    public int next()
    {
        TreeNode retVal = m_pathStack.pop();
        
        TreeNode curNode = retVal;
            
        if (curNode.right != null)
        {
            curNode = curNode.right;
            
            while (curNode != null)
            {
                m_pathStack.push(curNode);
            
                curNode = curNode.left;
            }
        }
        
        return retVal.val;
    }
}
