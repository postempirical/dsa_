class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // max heap with custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                if(Math.abs(a - x) == Math.abs(b - x)) {
                    return b - a;
                } 
                else {
                    return Math.abs(b - x) - Math.abs(a - x);
                }
            }
        );
      
        // pop all useless values
        List<Integer> res = new ArrayList<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        
        // empty remaining values into res arraylist, and sort it
        while (pq.size() > 0) res.add(pq.poll());
        Collections.sort(res);
        return res;
    }
}
