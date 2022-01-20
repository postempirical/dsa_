public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("#,");
                continue;
            }
            
            str.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        for (int i = 1; i < vals.length; i++) {
            TreeNode parent = q.poll();
            if (!vals[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                parent.left = left;
                q.add(left);
            }
            if (!vals[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                parent.right = right;
                q.add(right);
            } 
        }
        return root;
    }
}
