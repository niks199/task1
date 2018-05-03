public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder builder = new StringBuilder();
        
        //builder.append("[");
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        
        nodeQueue.offer(root);
        
        TreeNode currentNode;
        
        while (!nodeQueue.isEmpty())
        {
            currentNode = nodeQueue.poll();
            
            builder.append(currentNode.val);
            builder.append(",");
            
            if (currentNode.left != null)
            {
                nodeQueue.offer(currentNode.left);
            }

            if (currentNode.right != null)
            {
                nodeQueue.offer(currentNode.right);
            }
        }
        
        if (builder.charAt(builder.length() - 1) == ',')
        {
            builder.deleteCharAt(builder.length() - 1);
        }
            
        //builder.append("]");
        
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data.isEmpty())
        {
            return null;
        }
        
        final String[] tokens = data.split(Pattern.quote(","));
        
        for(int i = 0; i < tokens.length(); i++)
        {
            TreeNode currentNode = 
                new TreeNode(Integer.parseInt(tokens[i]));
            
            //currentNode
        }        
    }
}
