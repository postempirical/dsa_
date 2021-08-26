// tc = o(n+e), sc = o(n+e) + o(n) + o(n)
class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
      ArrayList<Integer> bfs = new ArrayList<>(); 
      boolean vis[] = new boolean[V + 1]; // 1 base indexing
      // Queue<Integer> q = new LinkedList<>();
        
      // enclose inside a for loop for disconnected graphs
      for (int i = 1; i <= V; i++) {
        if (vis[i] = false) {
          Queue<Integer> q = new LinkedList<>();
          q.add(0); 
          vis[0] = true; 

          while (!q.isEmpty())
          {
              Integer node = q.poll();
              bfs.add(node); 

              // Get all adjacent vertices of the dequeued vertex
              // If a adjacent has not been visited, then mark it
              // visited and enqueue it
              for(Integer it: adj.get(node)) {
                  if(vis[it] == false) {
                      vis[it] = true; 
                      q.add(it); 
                  } 
              }
          }
        
        return bfs; 
        
        // Code here
    }
}
