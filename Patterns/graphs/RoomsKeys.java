class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        // if any room is marked unvisited, return false
        for (boolean visit : visited) 
            if (!visit) return false;
        return true;
    }
    
    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        // mark reached room as true
        // get its keys and go to those rooms if not visited
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) dfs(key, rooms, visited);
        }
    }
}
