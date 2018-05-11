class Solution {
        
    public int closestValue(TreeNode root, double target)
    {
        if (root == null)
        {
            return 0;
        }
        
        double closest = root.val;
        
        while (root != null)
        {
            if (Math.abs(target - root.val) < Math.abs(target - closest))
            {
                closest = root.val;
            }
            
            if (target < root.val)
            {
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        
        return (int)closest;
    }
}
