class Solution {
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
            else {
                parent[root_v] = root_u;
                rank[root_u]++;
            }
            
            // after every successful union 
            // total components will decrease by 1
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        // if [i][j] is 1, union them
        // number of components ie count = total provinces
        for (int i = 0; i < n - 1; i++) 
            for (int j = i + 1; j < n; j++) 
                if (isConnected[i][j] == 1) uf.union(i, j);
        
        // return total provinces
        return uf.count();
    }
}
