class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0, j = 0, sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < N) {
            sum += Arr.get(j);
            if (j - i + 1 == K) {
                max = Math.max(max, sum);
                sum -= Arr.get(i);
                i++;
            }
            j++;
        }
        return max;
    }
}
