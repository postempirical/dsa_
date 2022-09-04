class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // VERTICALS -- LEVELS -- NODES
        // verticals will be -1, 0(root), 1, 2...
        // levels will be 0, 1, 2...
        // so each node will have a unique co-ordinate(vert, level)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // traverse the tree and add values to the data structure
        dfs(root, 0, 0, map);
        
        // traverse the data structure, add to list and return
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values()) {
            // add a new list for current vertical
            list.add(new ArrayList<>());
            // get all nodes on current vertical and add to the list
            for (PriorityQueue<Integer> nodes : vertical.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    
    public void dfs(TreeNode node, int vert, int level, 
                    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        
        // if vertical is not present in map, add it
        if (!map.containsKey(vert)) 
            map.put(vert, new TreeMap<>());
        
        // if level of a vertical is not in map, add it
        if (!map.get(vert).containsKey(level)) 
            map.get(vert).put(level, new PriorityQueue<>());
        
        // now we have both vert and level
        // so offer the value to the pq
        map.get(vert).get(level).offer(node.val);
        
        // go to next level nodes
        dfs(node.left, vert - 1, level + 1, map);
        dfs(node.right, vert + 1, level + 1, map);
        
    }
}
