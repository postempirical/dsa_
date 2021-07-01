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

// [2] -> Time: O(n), Space: O(n)
class twoSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();
		for (int num : array) {
			int guess = targetSum - num;
			if(nums.contains(guess)) {
				return new int[] {guess, num};
			}
			else {
				nums.add(num);
			}
		}
    return new int[0];
  }
}

// [3] -> Time: O(nlogn), Space O(1)
class twoSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int current = array[left] + array[right];
			if (current == targetSum) {
				return new int[] {array[left], array[right]};
			}
			else if (current < targetSum) {
				left++;
			}
			else right--;
		}			
    return new int[0];
  }
