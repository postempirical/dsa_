class Solution {
    public int makeConnected(int n, int[][] connections) {
        // to connect all nodes need ateleast n - 1 edges
        if (connections.length < n - 1) return -1;
        
        int m = connections.length;
        UnionFind uf = new UnionFind(n);
        
        // if parents are different, union them
        for (int[] c : connections) {
            if (uf.find(c[0]) != uf.find(c[1])) 
                uf.union(c[0], c[1]);
        }
        // total edges to total components - 1
        return uf.count - 1;
    }
    
    // template union find class
    class UnionFind {
        private int count = 0;
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public void union(int u, int v) {
            int root_u = find(u);
            int root_v = find(v);
            
            if (root_u == root_v) return;
            
            if (rank[root_u] > rank[root_v]) 
                parent[root_v] = root_u;
            
            else if (rank[root_v] > rank[root_u]) 
                parent[root_u] = root_v;
            
            else {
                parent[root_v] = root_u;
                rank[root_u]++;
            }
            
            count--;
        }
        
        public int count() {
            return count;
        }
    }
}
