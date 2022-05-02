class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = null;
        int n = edges.length;
        
        // n + 1 as starting node is 1
        UnionFind uf = new UnionFind(n + 1);
        
        // If connected components is equal before and after 
        // adding the edge, then the edge is redundant
        for (int[] edge : edges) {
            int before = uf.count();
            uf.union(edge[0], edge[1]);
            if (before == uf.count()) result = edge;
        }
        // since we need the last redundant edge we dont stop
        // otherwise for first redundant edge, use break
        return result;
    }
    
    // union find class
    class UnionFind {
        private int count = 0;
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            // initialise parent, rank array with size n
            parent = new int[n];
            rank = new int[n];
            count = n;
            
            // everyone is their own parent in the start
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                // rank[i] = 0;
            }
        }
        
        public int find(int node) {
            // loop till we reach the root of set
            // keep doing compression 
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public void union(int u, int v) {
            // get parents of both nodes
            int root_u = find(u);
            int root_v = find(v);
            
            // if parents same -> they are in same set
            if (root_u == root_v) return;
            
            // if rank if u's parent > rank of v's parent
            // make v's parent to u's parent
            if (rank[root_u] > rank[root_v]) 
                parent[root_v] = root_u;
            
            // vice versa 
            else if (rank[root_v] > rank[root_u]) 
                parent[root_u] = root_v;
            
            // if parents of u,v have same rank
            // connect any to any
            // increase rank to which connected
            parent[root_v] = root_u;
            rank[root_u]++;
            
            // after every successful union 
            // total components will decrease by 1
            count--;
        }
        
        public int count() {
            return count;
        }
    }
}
