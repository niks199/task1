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
        System.out.println("KthLargest k=" + k);
        
        m_k = k;
        
        for (int i = 0; i < nums.length; ++i)
        {
            System.out.println("nums[i]=" + nums[i]);
            
            insertNode(m_tree, nums[i]);
        }
    }
    
    public int add(int val)
    {
        System.out.println("add val=" + val);
        
        insertNode(m_tree, val);
        
        return getKLargest(m_tree, m_k);
    }
    
    public void insertNode(Node rootNode, int val)
    {
        if (m_tree == null)
        {
            m_tree = new Node(val);
            
            m_tree.m_count = 1;
            
            System.out.println("insertNode root node val=" + val);
            
            return;
        }

        if (rootNode != null)
        {
            rootNode.m_count += 1;
            
            System.out.println("insertNode rootNode.m_value=" + 
                               rootNode.m_value + "rootNode.m_count=" + rootNode.m_count);
        }
        
        if (rootNode != null && val >= rootNode.m_value)
        {
            if (rootNode.m_right != null)
            {
                System.out.println("insertNode go right val=" + val + 
                                   " rootNode.m_right.m_value=" + rootNode.m_right.m_value +
                                   " rootNode.m_right.m_count=" + rootNode.m_right.m_count);
                
                insertNode(rootNode.m_right, val);
            }
            else
            {
                System.out.println("insertNode val=" + val + " on the right");
                
                rootNode.m_right = new Node(val);
                rootNode.m_right.m_count = 1;
            }
        }
        else if (rootNode != null && val < rootNode.m_value)
        {
            if (rootNode.m_left != null)
            {
                System.out.println("insertNode go left val=" + val + 
                                   " rootNode.m_left=" + rootNode.m_left.m_value +
                                   " rootNode.m_left.m_count=" + rootNode.m_left.m_count);
                
                insertNode(rootNode.m_left, val);
            }
            else
            {
                System.out.println("insertNode val=" + val + " on the left");
                
                rootNode.m_left = new Node(val);
                rootNode.m_left.m_count = 1;
            }
        }
    }
    
    public int getKLargest(Node rootNode, int k)
    {
        System.out.println("getKLargest k=" + k);
        
        if (k == 0)
        {
            return rootNode.m_value;
        }
        
        if (rootNode.m_right != null && rootNode.m_right.m_count > k)
        {
            System.out.println("getKLargest rootNode.m_right.m_value=" + rootNode.m_right.m_value +
                              " rootNode.m_right.m_count=" + rootNode.m_right.m_count);
            
            return getKLargest(rootNode.m_right, k);
        }
        
        if (rootNode.m_right != null && rootNode.m_right.m_count <= k)
        {
            k = k - rootNode.m_right.m_count;

            if (k == 0)
            {
                return getKLargest(rootNode.m_right, k);
            }
        }
        
        k = k - 1;
        
        if (k == 0)
        {
            return getKLargest(rootNode, k);
        }
        
        
        if (rootNode.m_left != null)
        {
            return getKLargest(rootNode.m_left, k);
        }
        
        return -2;
    }
}
