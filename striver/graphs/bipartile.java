// DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!checkDFS(i, graph, color)) return false;
            }
        }
        return true;
    }
    
    public boolean checkDFS(int node, int graph[][], int color[]) {
        if (color[node] == -1) color[node] = 1;
        for (int it: graph[node]) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                if (!checkDFS(it, graph, color)) return false;
            }
            else if (color[it] == color[node]) return false;
        }
        return true;
    }
}


// BFS
class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(checkbfs(adj, i, color) == false) return false;
            }
        }
        return true;
    }
    
    public boolean checkbfs(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty()) {
            Integer nd = q.poll();
            for (Integer it: adj.get(nd)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[nd];
                    q.add(it);
                }  
                else if (color[it] == color[nd]) return false;
            }
        }
        return true;
    }
}
