// Method to find lowest common ancestor.
public Node lowestCommonAncestor(int val1, int val2,Node root){

    // Base condition to terminate.
    if(root == null){
        return null;
    }

    // While traversing, if we found root itself equal to val1/val2.
    // Then, root should be the lowest common ancestor.
    if(root.data == val1 || root.data == val2){
        return root;
    }

    // If not, do post-order traversing. Means, left node, then right 
    // node, then root iteslf (current node.)
    Node left = lowestCommonAncestor(val1, val2, root.left);
    Node right = lowestCommonAncestor(val1, val2, root.right);

    // While traversing, if we reach to a state, when root itself has left and 
    // right both children, then, this is the lowest common ancestor of val1, 
    // and val2. return this root.
    if(left != null && right != null){
        return root;
    }

    // If, root has only one child either  left or right child, then start 
    // traversing into that child.
    // If, root has no child, in that case. Return null. Means this tree does    
    // not contain lowest common ancestor of val1, and val2.
    return left != null ? left : right;
}
