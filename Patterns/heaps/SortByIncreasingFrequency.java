class Solution {
    public int[] frequencySort(int[] nums) {
        // create num -- freq map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        // create minheap and sort on freq
        // if same freq, insert into heap in decreasing order
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(b) == map.get(a)) return b - a;
                else return map.get(a) - map.get(b);
            });
        
        // add array values to pq
        for (int i : nums) {
            pq.add(i);
        }
        
        // empty pq into res[]
        int[] res = new int[nums.length];
        int i = 0;
        
        while (pq.size() > 0) res[i++] = pq.poll();
        return res;
    }
}
