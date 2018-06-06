class KthLargest {

    class Node
    {
        Node(int value)
        {
            m_value = value;
            
            m_count = 0;
        }
        
        public int m_value;
        
        public int m_count;
        
        public Node m_left;
        
        public Node m_right;
    }
    
    Node m_tree;
    
    int m_k;
    
    public KthLargest(int k, int[] nums)
    {
        m_k = k;
        
        for (int i = 0; i < nums.length(); ++i)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val)
    {
        if (m_tree == null)
        {
            m_tree = new Node(val);
            
            m_tree.m_count = 1;
        }
        else
        {
            insertNode(m_tree, val);
        }
        
        return getKLargest(m_tree, m_k);
    }
    
    public void insertNode(Node rootNode, int val)
    {
        if (rootNode != null && val >= rootNode.m_value)
        {
            rootNode.m_count += 1;
            
            if (rootNode.right != null)
            {
                insertNode(rootNode.right, val);
            }
            else
            {
                rootNode.right = new Node(val);
                rootNode.right.m_count = 1;
            }
        }
        else if (rootNode != null && val < rootNode.m_value)
        {
            rootNode.m_count += 1;
            
            if (rootNode.left != null)
            {
                insertNode(rootNode.left, val);
            }
            else
            {
                rootNode.left = new Node(val);
                rootNode.left.m_count = 1;
            }
        }
    }
    
    public int getKLargest(Node rootNode, int k)
    {
        if (rootNode == null)
        {
            return -1;
        }
        
        if (rootNode.m_count < k)
        {
            return -1;
        }
            
        
        return 0;
    }
}
