// dfs
class Solution {
    private boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1; 
        dfsVis[node] = 1; 
        
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                if(checkCycle(it, adj, vis, dfsVis) == true) {
                    return true; 
                }
            } else if(dfsVis[it] == 1) {
                return true; 
            }
        }
        dfsVis[node] = 0;
        return false; 
    }
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N]; 
        int dfsVis[] = new int[N]; 
        
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true; 
            }
        }
        return false; 
    }
}


// bfs
