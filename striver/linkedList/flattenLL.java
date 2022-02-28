class LinkedList
{
    // An utility function to merge two sorted linked lists
    Node merge(Node a, Node b)
    {
        // if first linked list is empty then second
        // is the answer & vice versa
        if (a == null) return b;
        if (b == null) return a;

        // compare the data members of the two linked lists
        // and put the larger one in the result
        Node result;
        if (a.data < b.data)
        {
            result = a;
            result.down = merge(a.down, b);
        }
        else
        {
            result = b;
            result.down = merge(a, b.down);
        }

        result.right = null; 
        return result;
    }

    Node flatten(Node root)
    {
        // Base Cases
        if (root == null || root.right == null)
            return root;

        // recur for list on right
        root.right = flatten(root.right);

        // now merge
        root = merge(root, root.right);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

}
