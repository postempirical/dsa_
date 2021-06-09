// Print an array of two values that equal target sum 

// [1] -> Time: O (n^2), Space: O(1)  
class twoSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		for (int i = 0; i < array.length - 1; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if (array[i] + array[j] == targetSum) {
					return new int[] {first, second}; 
				}
			}
		}
		return new int[0];
  }
}
