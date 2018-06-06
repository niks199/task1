class KthLargest {

    class Node
    {
        Node(int value)
        {
            m_value = value;
        }
        
        public int m_value;
        
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
        }
        else
        {
            if (val > m_tree.m_value)
            {
                //new Node(val)
            }
        }
        
        return 0;
    }
    
    public void insertNode(int val)
    {
        
    }
}
