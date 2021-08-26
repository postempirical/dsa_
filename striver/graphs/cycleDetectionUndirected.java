// undirected, dfs
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkCycle(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
    
    public boolean checkCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
    vis[node] = true;
    for (Integer it: adj.get(node)) {
        if (vis[it] == false) {
            if (checkCycle(it, node, vis, adj) == true) return true;
        }
        else if (it != parent) return true;
    }
    return false;
  }
}


// undirected, bfs
class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}

class Solution {
   static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
            boolean vis[], int parent[]) {
       Queue<Node> q =  new LinkedList<>(); //BFS
       q.add(new Node(s, -1));
       vis[s] =true;
       
       while(!q.isEmpty()) {
           int node = q.peek().first;
           int par = q.peek().second;
           q.remove(); 
           
           for(Integer it: adj.get(node)) {
               if(vis[it]==false)	{
                   q.add(new Node(it, node));
                   vis[it] = true; 
               }
               else if(par != it) return true;
           }
       }
       return false;
    }
  
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);  
        
        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(checkForCycle(adj, i,vis, parent)) 
                    return true;
    
        return false;
    }
}
