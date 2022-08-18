class Solution {
    public int minSetSize(int[] arr) {
        // num, freq map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        
        // maxheap on values of map
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int count = 0, half = arr.length / 2;
        
        // create maxheap with freq of numbers
        for(Integer value : map.values()) pq.offer(value);
        
        // keep removing top frequencies till half size is not zero
        // after each removal increase count
        while(!pq.isEmpty() && half > 0) { 
            half -= pq.poll();
            count++;
        }
        return count;
    }
}
