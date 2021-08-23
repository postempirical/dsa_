// minimum amount of change that you cannot create

// [1] -> Time: O(nlogn), Space: O(1)
class Program {
  public int nonConstructibleChange(int[] coins) {
    Arrays.sort(coins);
		int current = 0;
		for (int i : coins) {
			if (i > current + 1) return current + 1;
			current += i;	
		}
		return current + 1;
  }
}
