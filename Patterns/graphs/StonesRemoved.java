class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        // if any two points are on the same column or row
        // they are connected as an edge
        // find connected component, and remove all but one
        // count the number of disjoint components
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(stones[i], stones[j])) 
                    uf.union(i, j);
            }
        }
        return n - uf.count();
    }
    
    private boolean isConnected(int[] a, int[] b) {
        if (a[0] == b[0] || a[1] == b[1]) return true;
        return false;
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
