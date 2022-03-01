// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1/#

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> q = new ArrayDeque<>();  
        ArrayList<Long> list = new ArrayList<>();    
        int i = 0, j = 0;
        while (j < N) {
            // add neg values to queue
            if (A[j] < 0) q.add(A[j]);

            // if window size achieved
            if (j - i + 1 == K) {
                // add 0 to list if q has no values
                if (q.isEmpty()) list.add((long)0);
                
                // else add front of queue to list
                else list.add(q.peek());
                
                if (!q.isEmpty() && A[i] == q.peek()) q.remove();
                i++;
            }
            j++;
        }
        
        long[] res = new long[list.size()];
        for(int k = 0; k < list.size(); k++) {
          res[k] = list.get(k); 
        }
      return res;
    }
}
