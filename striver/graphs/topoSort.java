// dfs
class Solution {
    static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; 
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st); 
            } 
        }
        st.push(node); 
    }
  
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>(); 
        int vis[] = new int[N]; 
        
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }
        
        int topo[] = new int[N];
        int ind = 0; 
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        // for(int i = 0;i<N;i++) System.out.println(topo[i] + " "); 
        return topo; 
    }
}


// bfs (kahn's algo)
class Solution {
        int indeg[] = new int[V];
        int topo[] = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        
        int index = 0; 
        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[index++] = node;
            for (Integer it : adj.get(node)) {
                indeg[it]--;
                if (indeg[it] == 0) q.add(it);
            }
        }
        return topo;
    }
}
