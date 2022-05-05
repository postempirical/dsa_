class Solution {
    public boolean isBipartite(int[][] graph) {
        // create color array and fill it with -1
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        // if node not colored, dfs on it
        // if any dfs return false, exit, else return true
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) 
                if (!dfs(i, graph, color)) return false;
        }
        return true;
    }
    
    private boolean dfs(int node, int[][] graph, int[] color) {
        // color the node
        if (color[node] == -1) color[node] = 1;
        
        // get all its adjecent nodes
        // if they are uncolored, fill it with opposite color
        // then dfs on their adjecent nodes
        for (int i : graph[node]) {
            if (color[i] == -1) {
                color[i] = 1 - color[node];
                if (!dfs(i, graph,color)) return false;
            }
            // main condition
            // if adjecent and current node have same color, false
            else if (color[i] == color[node]) return false;
        }
        return true;
    }
}
