class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create num -- freq map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        // create minheap and sort on freq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        // add keys to pq
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }
        
        // empty pq into res[]
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
