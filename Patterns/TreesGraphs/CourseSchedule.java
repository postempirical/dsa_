class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // KAHNS ALGO
        List<Integer>[] graph = new LinkedList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = 0;
        
        // graph will have numcourses amout lists inside it
        for (int i = 0; i < numCourses; i++) graph[i] = new LinkedList<>();
        
        // graph index is pair 1, its neighbours are as list pair 0
        // increase indegree of pair 0th value
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }
        
        // add all 0 indegree nodes to queue
        for (int i = 0; i < indegree.length; i++) 
            if (indegree[i] == 0) q.add(i);
        
        // increase count when poll from queue
        // visit all the neighbours of current index course
        // decrease indegree of neighbours
        // add to q whenever indegree get 0
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int neighbour : graph[course]) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        // if count != total nodes => there is cycle
        return count == numCourses;
    }
}
