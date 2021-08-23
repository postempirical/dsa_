// square each element and then sort it

// [1] -> Time: O(nlogn), Space: O(n) 
class Program {

  public int[] sortedSquaredArray(int[] array) {
		int[] square = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			square[i] = array[i] * array[i];
		}
		Arrays.sort(square);
    return square;
  }
}


// [2] -> Time: O(n), Space: O(n) 
class Program {
  public int[] sortedSquaredArray(int[] array) {
    int[] square = new int[array.length];
		int start = 0;
		int end = array.length - 1;
		
		for (int i = array.length - 1; i >= 0; i--) {
			if (Math.abs(array[start]) > Math.abs(array[end])) {
				square[i] = array[start] * array[start];
				start++;
			}
			else {
				square[i] = array[end] * array[end];
				end--;
			}
		}
    return square;
  }
}
