// array of all triplets (in subarray) that equal target sum

// [1] -> Time: O(n^2), Space: O(n)
class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> triplet = new ArrayList<Integer[]>();
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			int left = i + 1;
			int right = array.length - 1;
			
			while (left < right) {
				int currentSum = array[i] + array[left] + array[right];
				if (currentSum == targetSum) {
					Integer[] newTriplet = {array[i], array[left], array[right]};
					triplet.add(newTriplet);
					left++;
					right--;
				}
				else if (currentSum > targetSum) {
					right--;
				}
				else if (currentSum < targetSum) {
					left++;
				}
			}
		}
		return triplet;
  }
}
