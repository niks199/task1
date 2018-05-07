/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void serializeImpl(TreeNode root, StringBuilder builder)
    {
        if (root == null)
        {
            builder.append("null");
            builder.append(",");
            
            return;
        }
            
        builder.append(root.val);
        builder.append(",");
        
        serializeImpl(root.left, builder);
        serializeImpl(root.right, builder);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder builder = new StringBuilder();
        
        serializeImpl(root, builder);
        
        if (builder.charAt(builder.length() - 1) == ',')
        {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    public TreeNode deserializeImpl(String[] tokens)
    {
        TreeNode root = null;
        
        if (readIndex < tokens.length)
        {
            int i = readIndex;
        
            ++readIndex;
        
            if (tokens[i].equals("null"))
            {
                return root;
            }
        
            root = new TreeNode( Integer.parseInt(tokens[i]) );
        
            root.left = deserializeImpl(tokens);
            root.right = deserializeImpl(tokens);
        }
        
        return root;
    }
    
    int readIndex;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data.isEmpty())
        {
            return null;
        }
        
        final String[] tokens = data.split(",");
        
        readIndex = 0;
            
        return deserializeImpl(tokens);
    }
}
